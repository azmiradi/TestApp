package azmithabet.com.testapp.presentation.di.core

import azmithabet.com.testapp.data.repository.associateddrug.AssociatedDrugRepositoryImpl
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugLocalDatasource
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugRemoteDatasource
import azmithabet.com.testapp.domain.repository.AssociatedDrugRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        associatedDrugRemoteDatasource: AssociatedDrugRemoteDatasource,
        associatedDrugLocalDatasource: AssociatedDrugLocalDatasource
    ): AssociatedDrugRepository {

        return AssociatedDrugRepositoryImpl(
            associatedDrugLocalDatasource, associatedDrugRemoteDatasource
        )


    }

}