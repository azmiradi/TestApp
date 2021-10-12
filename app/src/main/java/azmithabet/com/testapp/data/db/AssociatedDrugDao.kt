package azmithabet.com.testapp.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import azmithabet.com.testapp.data.model.AssociatedDrug

@Dao
interface AssociatedDrugDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAssociatedDrug(associatedDrugDaoList: List<AssociatedDrug>)

    @Query("DELETE FROM `associatedDrug`")
    suspend fun deleteAllAssociatedDrug()

    @Query("SELECT * FROM `associatedDrug`")
    suspend fun getAssociatedDrug(): List<AssociatedDrug>
}