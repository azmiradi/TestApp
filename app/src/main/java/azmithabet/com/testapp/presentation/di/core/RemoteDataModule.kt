package azmithabet.com.testapp.presentation.di.core

import azmithabet.com.testapp.data.api.AppServices
 import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugRemoteDatasource
import azmithabet.com.testapp.data.repository.associateddrug.datasourceImpl.AssociatedDrugRemoteDatasourceImpl
 import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(appServices: AppServices): AssociatedDrugRemoteDatasource {
        return AssociatedDrugRemoteDatasourceImpl(appServices)
    }




}