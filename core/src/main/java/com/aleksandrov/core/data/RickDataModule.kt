package com.aleksandrov.core.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class RickDataModule {

    @Module
    companion object {
        @Provides
        fun provideOkHttpClient(): OkHttpClient {
            return OkHttpClient()
        }

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
        fun provide(service: RickService):RickRepository {
            return RickRepository(service)
        }

    }

}