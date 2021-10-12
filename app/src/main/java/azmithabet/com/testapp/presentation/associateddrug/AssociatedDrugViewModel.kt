package azmithabet.com.testapp.presentation.associateddrug

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import azmithabet.com.testapp.R
import azmithabet.com.testapp.domain.usecase.GetAssociatedDrugUseCase
import azmithabet.com.testapp.domain.usecase.UpdateAssociatedDrugUseCase
import java.util.*

class AssociatedDrugViewModel(
    private val getAssociatedDrugUseCase: GetAssociatedDrugUseCase,
    private val updateAssociatedDrugUseCase: UpdateAssociatedDrugUseCase
) : ViewModel() {
    fun getAssociatedDrugs() = liveData {
        val artistList = getAssociatedDrugUseCase.execute()
        emit(artistList)
    }

    fun updateAssociatedDrugs() = liveData {
        val artistList = updateAssociatedDrugUseCase.execute()
        emit(artistList)
    }

    fun getGreetingMessage() = liveData {
        val c = Calendar.getInstance()
        val timeOfDay = c.get(Calendar.HOUR_OF_DAY)

        emit( when (timeOfDay) {
            in 0..11 -> R.string.good_morning
            in 12..15 ->  R.string.good_afternoon
            in 16..20 -> R.string.good_evening
            in 21..23 -> R.string.good_night
            else -> R.string.hello
        })
    }
}