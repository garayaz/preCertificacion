package araya.gonzalo.precertificacion.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import araya.gonzalo.precertificacion.data.response.PreCertResponse
import araya.gonzalo.precertificacion.domain.PreCertUseCase
import kotlinx.coroutines.launch

class PreCertViewModel(private val useCase: PreCertUseCase) : ViewModel()  {
    private var precertList = MutableLiveData<MutableList<PreCertResponse>>()
    val preCertLV
        get() = precertList
// se omite el init para tener mayor control de los llamados

    fun getAllVideoGamesFromServer() {
        viewModelScope.launch {
            try {
                // lo primero es ir a internet y traer los datos si hay conexion a internet
                val response =
                    useCase.getAllPreCertOnStock() //servicio que trae datos del server
                if (response.isNotEmpty()) {
                    useCase.saveAllPreCertOnDB(response) //se guarda en la base de datos
                    response.forEach { videoGame ->
                        val detailResponse = useCase.getPreCertByIdOnStock(videoGame.id)
                        useCase.saveDetailVideoGamesOnDB(detailResponse)
                    }
                }
                precertList.value = response
            } catch (e: Exception) {
                Log.e("Main Activity", "Not Network Connection")
                precertList.value = useCase.getAllVideoGamesFromDB()
            }

        }
    }

}