package azmithabet.com.testapp.data.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import azmithabet.com.testapp.data.model.AssociatedDrug
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AssociatedDrugDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var associatedDrugDao: AssociatedDrugDao
    private lateinit var appDatabase: AppDatabase

    @Before
    fun setUp() {
        appDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(), AppDatabase::class.java
        )
            .build()
        associatedDrugDao = appDatabase.associatedDrugDao()
    }

    @Test
    fun saveAssociatedDrugTest() = runBlocking {
       val associatedDrugList=  listOf(
           AssociatedDrug(1,"sprain","250 mg","sprain")
       , AssociatedDrug(2,"con cor","250 mg","con cor")
       )
        associatedDrugDao.saveAssociatedDrug(associatedDrugList)
        val associatedDrugListFomDb=associatedDrugDao.getAssociatedDrug()
        Truth.assertThat(associatedDrugListFomDb).isEqualTo(associatedDrugList)
    }

    @Test
    fun deleteAssociatedDrugTest() = runBlocking {
        val associatedDrugList=  listOf(
            AssociatedDrug(1,"sprain","250 mg","sprain")
            , AssociatedDrug(2,"con cor","250 mg","con cor")
        )
        associatedDrugDao.saveAssociatedDrug(associatedDrugList)
        associatedDrugDao.deleteAllAssociatedDrug()

        val associatedDrugListFomDb=associatedDrugDao.getAssociatedDrug()
        Truth.assertThat(associatedDrugListFomDb).isEmpty()
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }
}