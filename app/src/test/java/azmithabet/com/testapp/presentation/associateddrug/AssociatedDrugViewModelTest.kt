package azmithabet.com.testapp.presentation.associateddrug

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import azmithabet.com.testapp.data.model.AssociatedDrug
import azmithabet.com.testapp.data.repository.associateddrug.FakeAssociatedDrugRepository
import azmithabet.com.testapp.domain.usecase.GetAssociatedDrugUseCase
import azmithabet.com.testapp.domain.usecase.UpdateAssociatedDrugUseCase
import azmithabet.com.testapp.getOrAwaitValueTest
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssociatedDrugViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var associatedDrugViewModel: AssociatedDrugViewModel

    @Before
    fun setUp() {
        val fakeAssociatedDrugRepository = FakeAssociatedDrugRepository()

        val getAssociatedDrugUseCase = GetAssociatedDrugUseCase(fakeAssociatedDrugRepository)
        val updateAssociatedDrugUseCase = UpdateAssociatedDrugUseCase(fakeAssociatedDrugRepository)

        associatedDrugViewModel = AssociatedDrugViewModel(
            getAssociatedDrugUseCase,
            updateAssociatedDrugUseCase
        )
    }

    @Test
    fun getAssociatedDrugTest() {
        val associatedDrugList: MutableList<AssociatedDrug> = ArrayList()
        associatedDrugList.add(AssociatedDrug(1, "test1", "test1", "test1"))
        associatedDrugList.add(AssociatedDrug(2, "test2", "test2", "test2"))
        associatedDrugList.add(AssociatedDrug(3, "test3", "test3", "test3"))

        val associatedDrugListFromViewModel =
            associatedDrugViewModel.getAssociatedDrugs().getOrAwaitValueTest()
        Truth.assertThat(associatedDrugListFromViewModel).isEqualTo(associatedDrugList)

    }

    @Test
    fun updateAssociatedDrugTest() {
        val associatedDrugList: MutableList<AssociatedDrug> = ArrayList()
        associatedDrugList.add(AssociatedDrug(1, "update1", "update1", "update1"))
        associatedDrugList.add(AssociatedDrug(2, "update2", "update2", "update2"))
        associatedDrugList.add(AssociatedDrug(3, "update3", "update3", "update3"))

        val associatedDrugListFromViewModel =
            associatedDrugViewModel.updateAssociatedDrugs().getOrAwaitValueTest()
        Truth.assertThat(associatedDrugListFromViewModel).isEqualTo(associatedDrugList)

    }
}