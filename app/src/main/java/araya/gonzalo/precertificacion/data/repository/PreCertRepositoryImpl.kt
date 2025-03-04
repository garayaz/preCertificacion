package araya.gonzalo.precertificacion.data.repository

import araya.gonzalo.precertificacion.data.local.dao.PreCertDao
import araya.gonzalo.precertificacion.data.network.api.PreCertService
import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PreCertRepositoryImpl(private var apiservice: PreCertService, private var daoDB: PreCertDao) : PreCertRepository  {

    override suspend fun fetchPreCert(): MutableList<PreCertResponse> {
        return withContext(Dispatchers.IO){
            // se declara un hilo para que se ejecute en ese hilo de
            // entrada y salida.
            // ahora me conecto a la capa anterior para obtener los datos usando getVideoGames de la api
            // "VideoGameApiClient" que es la que se conecta al servicio videoGamesService, para eso paso
            // el parametro apiservice: videoGameService
            // Ahora puedo usar el apiservice
            val listPreCert = apiservice.getAllCiudades() // esta es una funcion lambda por lo
            // que se requiere devolver un valor
            listPreCert
        }
        // aca despues iran los fetch a base de datos o a otros servicios
    }

    override suspend fun fetchPreCertById(idPreCertService: Long): PreCertDetailsResponse {
        return withContext(Dispatchers.IO){
            val preCertDetail = apiservice.getPreCertById(idPreCertService)
            preCertDetail
        }
    }
    // Implementacion de las consultas a la base de datos a través de los métodos del DAO
    override suspend fun saveAllPreCertOnDB(PreCert: MutableList<PreCertResponse>) {
        return withContext(Dispatchers.IO){
            daoDB.insertPreCert(PreCert)
        }
    }

    override suspend fun getAllPreCertFromDB(): MutableList<PreCertResponse> {
        return withContext(Dispatchers.IO){
            val response = daoDB.getAllPreCert()
            response
        }
    }

    override suspend fun saveDetailPreCertOnDB(detailPreCertResponse: PreCertDetailsResponse) {
        return withContext(Dispatchers.IO){
            daoDB.insertPreCertDetail(detailPreCertResponse)
        }
    }

    override suspend fun getDetailPreCertFromDB(idPreCert: Long): PreCertDetailsResponse {
        return withContext(Dispatchers.IO){
            val response = daoDB.getPreCertDetailById(idPreCert)
            response
        }
    }

}