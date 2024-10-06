package town.millie.core.contract.policy

data class ServicePolicy(
    val writeTimeout: Int,
    val readTimeout: Int,
    val connectTimeout: Int,
)
