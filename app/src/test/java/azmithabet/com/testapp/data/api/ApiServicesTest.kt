package azmithabet.com.testapp.data.api
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServicesTest {

    private lateinit var service: AppServices
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppServices::class.java)


    }

    private fun enqueueMockResponse(
        fileName:String
    ){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }

    @Test
    fun getAssociatedDrugsTest(){
        runBlocking {
            enqueueMockResponse("associateddrugresponse.json")
            val responseBody = service.getAssociatedDrugs().body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/67075475-c2fb-444f-bbe1-0335565fd699")


        }
    }

    @Test
    fun getAssociatedDrugsSize(){
        runBlocking {
            enqueueMockResponse("associateddrugresponse.json")
            val responseBody = service.getAssociatedDrugs().body()
            val medicationsList = responseBody!!.medications
            assertThat(medicationsList!!.size).isEqualTo(4)

        }
    }

    @Test
    fun getAssociatedDrugsCorrectContent(){
        runBlocking {
            enqueueMockResponse("associateddrugresponse.json")
            val responseBody = service.getAssociatedDrugs().body()
            val medicationsList = responseBody!!.medications
            val associatedDrug = medicationsList!![0]
            assertThat(associatedDrug.id).isEqualTo(1)
            assertThat(associatedDrug.dose).isEqualTo("")
            assertThat(associatedDrug.name).isEqualTo("asprin")
            assertThat(associatedDrug.strength).isEqualTo("500 mg")
        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}