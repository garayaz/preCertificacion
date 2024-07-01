package araya.gonzalo.precertificacion.data.repository

import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse

interface PreCertRepository {

    // Trabajar con API
    suspend fun fetchPreCert(): MutableList<PreCertResponse>
    suspend fun fetchPreCertById(idPreCertService: Long): PreCertDetailsResponse

    // Trabajar con la base de datos

    suspend fun saveAllPreCertOnDB(preCert: MutableList<PreCertResponse>)
    suspend fun getAllPreCertFromDB(): MutableList<PreCertResponse>
    suspend fun saveDetailPreCertOnDB(detailPreCertResponse: PreCertDetailsResponse)
    suspend fun getDetailPreCertFromDB(idPreCert: Long): PreCertDetailsResponse

}