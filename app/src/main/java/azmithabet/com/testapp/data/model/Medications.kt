package azmithabet.com.testapp.data.model

import com.google.gson.annotations.SerializedName

data class Medications (
    @SerializedName("medications_classes")
    val medications:List<AssociatedDrug>?=null)