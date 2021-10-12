package azmithabet.com.testapp.presentation.di.core

import android.content.Context
import azmithabet.com.testapp.presentation.di.associateddrug.AssociatedDruSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [AssociatedDruSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}