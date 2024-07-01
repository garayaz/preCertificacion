package araya.gonzalo.precertificacion.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import araya.gonzalo.precertificacion.domain.PreCertUseCase

class ViewModelFactory(private val preCertUseCase: PreCertUseCase) : ViewModelProvider.Factory {
    // esta es una funcion de extension factory
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreCertViewModel::class.java)) {
            return PreCertViewModel(preCertUseCase) as T
        }
        throw IllegalArgumentException("ViewModel no encontrado")
    }
}