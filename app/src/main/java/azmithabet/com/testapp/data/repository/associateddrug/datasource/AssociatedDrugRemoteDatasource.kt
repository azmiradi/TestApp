package azmithabet.com.testapp.data.repository.associateddrug.datasource

import azmithabet.com.testapp.data.model.Medications
import retrofit2.Response

interface AssociatedDrugRemoteDatasource {
  suspend fun getAssociatedDrugs():Response<Medications>
}