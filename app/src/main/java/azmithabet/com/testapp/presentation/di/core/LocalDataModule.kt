package azmithabet.com.testapp.presentation.di.core

import azmithabet.com.testapp.data.db.AssociatedDrugDao
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugLocalDatasource
import azmithabet.com.testapp.data.repository.associateddrug.datasourceImpl.AssociatedDrugLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideAssociatedDrugLocalDataSource(associatedDrugDao: AssociatedDrugDao)
            : AssociatedDrugLocalDatasource {
        return AssociatedDrugLocalDatasourceImpl(associatedDrugDao)
    }


}