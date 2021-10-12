package azmithabet.com.testapp.presentation.di.associateddrug

import azmithabet.com.testapp.domain.usecase.GetAssociatedDrugUseCase
import azmithabet.com.testapp.domain.usecase.UpdateAssociatedDrugUseCase
import azmithabet.com.testapp.presentation.associateddrug.AssociatedDrugViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AssociatedDruModule {
    @AssociatedDruScope
    @Provides
    fun provideAssociatedDruViewModelFactory(
        getAssociatedDruSUseCase: GetAssociatedDrugUseCase,
        updateAssociatedDrugsUseCase: UpdateAssociatedDrugUseCase
    ): AssociatedDrugViewModelFactory {
        return AssociatedDrugViewModelFactory(
            getAssociatedDruSUseCase,
            updateAssociatedDrugsUseCase
        )
    }

}