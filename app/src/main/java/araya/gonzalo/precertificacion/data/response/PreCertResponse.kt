package araya.gonzalo.precertificacion.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "precert_response")
data class PreCertResponse(
    @PrimaryKey
    val id: Long,
    val logo: String,
    val rating: String,
    val location: String,
    val aniversary: String
)
