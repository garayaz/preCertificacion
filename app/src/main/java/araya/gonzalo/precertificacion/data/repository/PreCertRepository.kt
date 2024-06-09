package araya.gonzalo.precertificacion.data.repository

import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse

interface PreCertRepository {

    // Trabajar con API
    suspend fun fetchPreCert(): MutableList<PreCertResponse>
    suspend fun fetchPreCertById(idPreCertService: Long): PreCertDetailsResponse
}