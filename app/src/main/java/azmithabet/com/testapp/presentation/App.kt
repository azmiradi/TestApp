package azmithabet.com.testapp.presentation

import android.app.Application
import azmithabet.com.testapp.BuildConfig
import azmithabet.com.testapp.presentation.di.associateddrug.AssociatedDruSubComponent
import azmithabet.com.testapp.presentation.di.core.*
import javax.inject.Inject

class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule())
            .build()

    }

    override fun createAssociatedDrugSubComponent(): AssociatedDruSubComponent {
        return appComponent.movieSubComponent().create()
    }


}