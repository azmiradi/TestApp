package azmithabet.com.testapp.presentation.di.core

import android.content.Context
import androidx.room.Room
import azmithabet.com.testapp.data.db.AppDatabase
import azmithabet.com.testapp.data.db.AssociatedDrugDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMovieDataBase(context: Context):AppDatabase{
     return Room.databaseBuilder(context,AppDatabase::class.java,
         "app_test_client")
         .build()
    }

    @Singleton
    @Provides
    fun provideAssociatedDrugDao(appDatabase: AppDatabase):AssociatedDrugDao{
        return appDatabase.associatedDrugDao()
    }

}