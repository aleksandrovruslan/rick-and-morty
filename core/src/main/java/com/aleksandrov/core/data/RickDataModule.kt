package com.aleksandrov.core.data

import android.app.Application
import com.aleksandrov.core.utils.CacheInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
object RickDataModule {

    @Singleton
    @Provides
    fun provideCacheInterceptor(): CacheInterceptor {
        return CacheInterceptor()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        application: Application,
        cacheInterceptor: CacheInterceptor
    ): OkHttpClient {
        val cache = Cache(
            File(application.cacheDir, "http_cache")
            , 10L * 1024L * 1024L
        )
        return OkHttpClient.Builder()
            .addInterceptor(cacheInterceptor)
            .cache(cache)
            .build();
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(RickService.ENDPOINT)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideRickService(retrofit: Retrofit): RickService {
        return retrofit.create(RickService::class.java)
    }

    @Provides
    @Singleton
    fun provide(service: RickService): RickRepository {
        return RickRepository(service)
    }

}