package araya.gonzalo.precertificacion.data.network.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {

    fun getRetrofit(): Retrofit {

        // el interceptor es para ver la respuesta de la API en el log, para esto se debe instalar
        // la dependencia okhttp3-logging-interceptor en el gradle
        val intercepter = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().apply {
            this.addInterceptor(intercepter)
        }.build()
        // Builder es una clase que permite construir el retrofit
        return Retrofit.Builder()
            // BaseUrl es la dirección del servidor al que me voy a conectar
            .baseUrl("https://retoolapi.dev/8vurBF/")
            // Convertir el json a un objeto
            .addConverterFactory(GsonConverterFactory.create())
            // Crear el retrofit
            .build()
    }
}