package araya.gonzalo.precertificacion.data.network.api

import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PreCertService {
    @GET("ciudades") // https://retoolapi.dev/8vurBF/ciudades
    suspend fun getAllCiudades(): MutableList<PreCertResponse>
    // como puede haber demora en la conexion, se debe usar corrutinas, la corrutina va a
// llamar esta funcion

    @GET("cuidades/{id}")
    suspend fun getPreCertById(@Path("id") idPreCert : Long ): PreCertDetailsResponse

}