package azmithabet.com.testapp.data.repository.associateddrug

import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.domain.repository.AssociatedDrugRepository

class FakeAssociatedDrugRepository : AssociatedDrugRepository {
    private val associatedDrugList: MutableList<AssociatedDrug> = ArrayList()

    init {
        associatedDrugList.add(AssociatedDrug(1, "test1", "test1", "test1"))
        associatedDrugList.add(AssociatedDrug(2, "test2", "test2", "test2"))
        associatedDrugList.add(AssociatedDrug(3, "test3", "test3", "test3"))
    }

    override suspend fun getAssociatedDrugs(): List<AssociatedDrug> {
        return associatedDrugList
    }

    override suspend fun updateAssociatedDrugs(): List<AssociatedDrug> {
        associatedDrugList.clear()
        associatedDrugList.add(AssociatedDrug(1, "update1", "update1", "update1"))
        associatedDrugList.add(AssociatedDrug(2, "update2", "update2", "update2"))
        associatedDrugList.add(AssociatedDrug(3, "update3", "update3", "update3"))
        return associatedDrugList
    }
}