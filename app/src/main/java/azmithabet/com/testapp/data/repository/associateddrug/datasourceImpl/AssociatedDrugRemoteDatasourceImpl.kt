package azmithabet.com.testapp.data.repository.associateddrug.datasourceImpl

import azmithabet.com.testapp.data.api.AppServices
import azmithabet.com.testapp.data.repository.associateddrug.datasource.AssociatedDrugRemoteDatasource

class AssociatedDrugRemoteDatasourceImpl(private val appServices: AppServices) :
    AssociatedDrugRemoteDatasource {
    override suspend fun getAssociatedDrugs() = appServices.getAssociatedDrugs()
}