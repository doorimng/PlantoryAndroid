// SmartFarmApi.kt

import retrofit2.Call
import retrofit2.http.GET

interface SmartFarmApi {
    @GET("/api/latest_sensor_data")
    fun getLatestSensorData(): Call<SensorDataResponse>
}