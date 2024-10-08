package town.millie.core.domain.usecase

import dagger.Reusable
import javax.inject.Inject
import town.millie.core.data.repository.ReadNewsRepository
import town.millie.core.model.entity.News

@Reusable
class UpdateReadNewsUseCase @Inject constructor(
    private val repo: ReadNewsRepository,
) {

    suspend operator fun invoke(
        news: News,
        country: String,
    ) {
        repo.insertReadNews(
            id = news.toString(),
            country = country,
        )
    }
}
