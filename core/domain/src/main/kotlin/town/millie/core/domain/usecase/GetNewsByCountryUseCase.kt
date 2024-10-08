package town.millie.core.domain.usecase

import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import town.millie.core.data.repository.NewsRepository
import town.millie.core.model.entity.News

@Reusable
class GetNewsByCountryUseCase @Inject constructor(
    private val repo: NewsRepository,
) {
    operator fun invoke(
        country: String,
    ): Flow<List<News>> {
        return flow {
            emit(
                repo
                    .getNewsByCountry(
                        country = country,
                    ),
            )
        }
    }
}
