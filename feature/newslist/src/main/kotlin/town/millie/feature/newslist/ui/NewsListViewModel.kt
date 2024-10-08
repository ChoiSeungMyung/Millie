package town.millie.feature.newslist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import town.millie.core.domain.usecase.GetNewsByCountryUseCase
import town.millie.core.domain.usecase.GetReadNewsIdByCountryUseCase
import town.millie.core.domain.usecase.UpdateReadNewsUseCase
import town.millie.core.model.entity.News

@HiltViewModel
class NewsListViewModel @Inject constructor(
    getNewsByCountryUseCase: GetNewsByCountryUseCase,
    getReadNewsByCountryUseCase: GetReadNewsIdByCountryUseCase,
    private val updateReadNewsUseCase: UpdateReadNewsUseCase,
) : ViewModel() {
    val news: StateFlow<PersistentList<Pair<News, Boolean>>> =
        getNewsByCountryUseCase(country = COUNTRY)
            .combine(getReadNewsByCountryUseCase(country = COUNTRY))
            { news, readNews ->
                news.map {
                    it to readNews.contains(it.toString())
                }
                    .toPersistentList()
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = persistentListOf(),
            )

    fun updateReadNews(
        news: News,
    ) {
        viewModelScope
            .launch {
                updateReadNewsUseCase(
                    news = news,
                    country = COUNTRY,
                )
            }
    }

    companion object {
        private const val COUNTRY = "us"
    }
}
