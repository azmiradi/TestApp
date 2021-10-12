package azmithabet.com.testapp.presentation.associateddrug

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import azmithabet.com.testapp.domain.usecase.GetAssociatedDrugUseCase
import azmithabet.com.testapp.domain.usecase.UpdateAssociatedDrugUseCase

class AssociatedDrugViewModelFactory(private val getAssociatedDrugUseCase: GetAssociatedDrugUseCase
                                     , private val updateAssociatedDrugUseCase: UpdateAssociatedDrugUseCase): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AssociatedDrugViewModel(
            getAssociatedDrugUseCase,
            updateAssociatedDrugUseCase
        ) as T
    }
}