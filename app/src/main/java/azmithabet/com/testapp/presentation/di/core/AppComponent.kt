package azmithabet.com.testapp.presentation.di.core

import azmithabet.com.testapp.presentation.di.associateddrug.AssociatedDruSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AppModule::class,
    NetModule::class,
    DataBaseModule::class,
    UseCaseModule::class,
    RepositoryModule::class,
    RemoteDataModule::class,
    LocalDataModule::class]
)
interface AppComponent {

  fun movieSubComponent(): AssociatedDruSubComponent.Factory

}
