package azmithabet.com.testapp.data.repository.associateddrug

import android.util.Log
import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugLocalDatasource
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugRemoteDatasource
import azmithabet.com.testapp.domain.repository.AssociatedDrugRepository

class AssociatedDrugRepositoryImpl(
    private val associatedDrugLocalDatasource: AssociatedDrugLocalDatasource,
    private val associatedDrugRemoteDatasource: AssociatedDrugRemoteDatasource
) : AssociatedDrugRepository {

    override suspend fun getAssociatedDrugs(): List<AssociatedDrug> {
        return getAssociatedDrugsFromDB()
    }

    override suspend fun updateAssociatedDrugs(): List<AssociatedDrug>? {
        val associatedDrugList = getAssociatedDrugsFromAPI()
        associatedDrugLocalDatasource.clearAll()
        associatedDrugLocalDatasource.saveAssociatedDrugsToDB(associatedDrugList)
        return associatedDrugList
    }

    suspend fun getAssociatedDrugsFromDB(): List<AssociatedDrug> {
        lateinit var associatedDrugList: List<AssociatedDrug>
        try {
            associatedDrugList = associatedDrugLocalDatasource.getAssociatedDrugsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if (associatedDrugList.isNotEmpty()) {
            return associatedDrugList
        } else {
            associatedDrugList = getAssociatedDrugsFromAPI()
            associatedDrugLocalDatasource.saveAssociatedDrugsToDB(associatedDrugList)
        }

        return associatedDrugList
    }

    suspend fun getAssociatedDrugsFromAPI(): List<AssociatedDrug> {
        lateinit var associatedDrugList: List<AssociatedDrug>
        try {
            val response = associatedDrugRemoteDatasource.getAssociatedDrugs()
            val body = response.body()
            if (body != null) {
                associatedDrugList = body.medications!!
            }
        } catch (exception: java.lang.Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return associatedDrugList
    }

}