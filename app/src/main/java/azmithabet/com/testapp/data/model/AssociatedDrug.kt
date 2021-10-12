package azmithabet.com.testapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "associatedDrug")
data class AssociatedDrug(

	@PrimaryKey
	@SerializedName("id")
	val id: Int? = null,
	@SerializedName("dose")
	val dose: String? = null,

	@SerializedName("strength")
	val strength: String? = null,

	@SerializedName("name")
	val name: String? = null

)
