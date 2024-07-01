package araya.gonzalo.precertificacion.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import araya.gonzalo.precertificacion.data.local.dao.PreCertDao
import araya.gonzalo.precertificacion.data.response.PreCertDetailsResponse
import araya.gonzalo.precertificacion.data.response.PreCertResponse

@Database(
    entities = [PreCertResponse::class, PreCertDetailsResponse::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun PreCertDAO(): PreCertDao

    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDatabase(context: Context): AppDataBase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "videoGame_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}