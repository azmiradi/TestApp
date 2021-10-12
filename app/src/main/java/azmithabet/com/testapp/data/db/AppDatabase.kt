package azmithabet.com.testapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import azmithabet.com.testapp.data.model.AssociatedDrug


@Database(
    entities = [AssociatedDrug::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun associatedDrugDao(): AssociatedDrugDao

}