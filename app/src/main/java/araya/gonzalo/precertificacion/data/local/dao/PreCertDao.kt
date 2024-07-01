package araya.gonzalo.precertificacion.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse

@Dao
interface PreCertDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPreCert(videoGameResponse: MutableList<PreCertResponse>)
    @Query("SELECT * FROM precert_response")
    suspend fun getAllPreCert(): MutableList<PreCertResponse>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPreCertDetail(videoGameDetail: PreCertDetailsResponse)
    @Query("SELECT * FROM precert_detail_response WHERE id = :idVideoGame")
    suspend fun getPreCertDetailById  (idVideoGame: Long): PreCertDetailsResponse

}