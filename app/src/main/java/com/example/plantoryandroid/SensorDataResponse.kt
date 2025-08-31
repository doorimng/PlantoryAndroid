// SensorDataResponse.kt

import com.google.gson.annotations.SerializedName

data class SensorDataResponse(
    val id: Int,
    val timestamp: String,
    @SerializedName("soil_moisture") val soilMoisture: Double,
    @SerializedName("air_temperature") val airTemperature: Double,
    @SerializedName("air_humidity") val airHumidity: Double,
    @SerializedName("light_intensity") val lightIntensity: Double,
    @SerializedName("water_level") val waterLevel: Double,
    @SerializedName("strawberry_ripeness_score") val strawberryRipenessScore: Double?,
    @SerializedName("strawberry_ripeness_text") val strawberryRipenessText: String?
)