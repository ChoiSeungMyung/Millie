package town.millie.core.domain.usecase

import dagger.Reusable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import town.millie.core.data.repository.ReadNewsRepository

@Reusable
class GetReadNewsIdByCountryUseCase @Inject constructor(
    private val repo: ReadNewsRepository,
) {
    operator fun invoke(
        country: String,
    ): Flow<List<String>> {
        return repo
            .getReadNewsByCountry(country = country)
            .map { it.map { readNews -> readNews.id } }
    }
}
