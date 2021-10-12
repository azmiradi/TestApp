package azmithabet.com.testapp.domain.usecase

import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.domain.repository.AssociatedDrugRepository

class GetAssociatedDrugUseCase(private val associatedDrugRepository: AssociatedDrugRepository) {
    suspend fun execute(): List<AssociatedDrug>? = associatedDrugRepository.getAssociatedDrugs()
}