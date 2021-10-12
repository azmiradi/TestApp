package azmithabet.com.testapp.presentation

import azmithabet.com.testapp.presentation.di.associateddrug.AssociatedDruSubComponent

interface Injector {
    fun createAssociatedDrugSubComponent(): AssociatedDruSubComponent
}
