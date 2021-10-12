package azmithabet.com.testapp.presentation.di.associateddrug

import azmithabet.com.testapp.presentation.associateddrug.AssociatedDrugActivity
import dagger.Subcomponent

@AssociatedDruScope
@Subcomponent(modules = [AssociatedDruModule::class])
interface AssociatedDruSubComponent {
    fun inject(associatedDrugActivity: AssociatedDrugActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): AssociatedDruSubComponent
    }

}

