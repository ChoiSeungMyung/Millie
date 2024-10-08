package town.millie.core.network.interceptor

import javax.inject.Qualifier

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class LoggingInterceptor

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class HeaderInterceptor
