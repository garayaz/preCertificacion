package araya.gonzalo.precertificacion.presentation.adapter

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import araya.gonzalo.precertificacion.data.response.PreCertResponse
import araya.gonzalo.precertificacion.databinding.PrecertItemBinding
import com.squareup.picasso.Picasso

// En la definicion de clase VideoGameAdapter: da la opcion de implementar miembros
class PreCertAdapter : RecyclerView.Adapter<PreCertAdapter.ViewHolder>() {
    // se define variable necesaria para la creacion de la vista
    lateinit var onItemClickListener: (PreCertResponse) -> Unit

    var preCert = mutableListOf<PreCertResponse>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            this.notifyDataSetChanged() // le indica a recycled view que hay cambios
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PrecertItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val videoGame = preCert[position]
        holder.bindPreCert(videoGame)
    }

    override fun getItemCount(): Int {
        return preCert.size
    }

    inner class ViewHolder(private var binding: PrecertItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindPreCert(preCert: PreCertResponse) {
            binding.imgCity.setImageResource(0)
            Picasso.get()
                .load(preCert.logo)
                .centerCrop()
                .fit()
                .into(binding.imgCity)
            binding.txtNameCity.text = preCert.location
            binding.txtReleasedCity.text = preCert.aniversary
            binding.txtRatingCity.text = preCert.rating.toString()
            // corrige error de la altura del item por imagenes muy grandes
            var layoutParams = binding.root.layoutParams as RecyclerView.LayoutParams
            layoutParams.height = RecyclerView.LayoutParams.WRAP_CONTENT
            binding.root.layoutParams = layoutParams
// Aca se activa el clickListener, despues de pintar todos los elementos en la vista
            clickVideoGameListener(preCert)
        }

        private fun clickVideoGameListener(preCert: PreCertResponse) {
            binding.root.setOnClickListener {
                if (::onItemClickListener.isInitialized)
                    onItemClickListener(preCert)
                else
                    Log.e("PreCertAdapter", "onItemClickListener no inicializada")
            }
        }
    }
}