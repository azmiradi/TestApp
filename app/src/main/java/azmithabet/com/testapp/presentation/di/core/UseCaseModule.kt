package azmithabet.com.testapp.presentation.di.core

import azmithabet.com.testapp.domain.repository.AssociatedDrugRepository
import azmithabet.com.testapp.domain.usecase.GetAssociatedDrugUseCase
import azmithabet.com.testapp.domain.usecase.UpdateAssociatedDrugUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetAssociatedDrugUseCase(associatedDrugRepository: AssociatedDrugRepository):
            GetAssociatedDrugUseCase {
        return GetAssociatedDrugUseCase(associatedDrugRepository)
    }
    @Provides
    fun provideUpdateAssociatedDrugUseCase(associatedDrugRepository: AssociatedDrugRepository):
            UpdateAssociatedDrugUseCase {
        return UpdateAssociatedDrugUseCase(associatedDrugRepository)
    }

}