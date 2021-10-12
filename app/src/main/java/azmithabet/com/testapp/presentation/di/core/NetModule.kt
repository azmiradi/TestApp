package azmithabet.com.testapp.presentation.di.core

import azmithabet.com.testapp.data.api.AppServices
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideAppServices(retrofit: Retrofit): AppServices {
        return retrofit.create(AppServices::class.java)
    }

}