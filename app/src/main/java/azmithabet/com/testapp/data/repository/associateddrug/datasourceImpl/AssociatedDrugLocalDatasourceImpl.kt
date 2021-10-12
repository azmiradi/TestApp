package azmithabet.com.testapp.data.repository.associateddrug.datasourceImpl

import azmithabet.com.testapp.data.db.AssociatedDrugDao
import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AssociatedDrugLocalDatasourceImpl
    (private val associatedDrugDao: AssociatedDrugDao)
    : AssociatedDrugLocalDatasource {

    override suspend fun saveAssociatedDrugsToDB
                (associatedDrugList: List<AssociatedDrug>) {
        CoroutineScope(Dispatchers.IO).launch {
              associatedDrugDao.saveAssociatedDrug(associatedDrugList)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            associatedDrugDao.deleteAllAssociatedDrug()
        }
     }

    override suspend fun getAssociatedDrugsFromDB()=associatedDrugDao.getAssociatedDrug()
}