package araya.gonzalo.precertificacion.domain

import araya.gonzalo.precertificacion.data.repository.PreCertRepositoryImpl
import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse

class PreCertUseCase(private val repository: PreCertRepositoryImpl) {
    // le doy el nombre del negocio
    suspend fun getAllPreCertOnStock(): MutableList<PreCertResponse> {
        return repository.fetchPreCert() // vamos a buscar la lista de videojuegos y la
        // devolvemos con return
    }

    suspend fun getPreCertByIdOnStock(idVideoGame: Long): PreCertDetailsResponse {
        return repository.fetchPreCertById(idVideoGame)
    }

}