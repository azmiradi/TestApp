package azmithabet.com.testapp.data.api

import azmithabet.com.testapp.BuildConfig
import azmithabet.com.testapp.data.model.Medications
import retrofit2.Response
import retrofit2.http.GET

interface AppServices {
    @GET(BuildConfig.MEDICATIONS_API_END_POINT)
    suspend fun getAssociatedDrugs(): Response<Medications>

}