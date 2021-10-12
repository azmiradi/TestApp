package azmithabet.com.testapp.data.repository.associateddrug.datasource

import azmithabet.com.testapp.data.model.AssociatedDrug

interface AssociatedDrugLocalDatasource {
    suspend fun saveAssociatedDrugsToDB(associatedDrugList: List<AssociatedDrug>)

    suspend fun clearAll()

    suspend fun getAssociatedDrugsFromDB(): List<AssociatedDrug>
}