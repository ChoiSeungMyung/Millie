package town.millie.core.contract

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class BaseUrl

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApiKey

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class WriteTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ReadTimeout

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ConnectTimeout
