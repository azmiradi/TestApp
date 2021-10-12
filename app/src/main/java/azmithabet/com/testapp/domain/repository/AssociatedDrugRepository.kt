package azmithabet.com.testapp.domain.repository

import azmithabet.com.testapp.data.model.AssociatedDrug


interface AssociatedDrugRepository {

    suspend fun getAssociatedDrugs():List<AssociatedDrug>?

    suspend fun updateAssociatedDrugs():List<AssociatedDrug>?


}