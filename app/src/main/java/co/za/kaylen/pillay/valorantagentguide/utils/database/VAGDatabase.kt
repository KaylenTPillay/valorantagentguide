package co.za.kaylen.pillay.valorantagentguide.utils.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import co.za.kaylen.pillay.valorantagentguide.agentitem.dao.DAOAgent
import co.za.kaylen.pillay.valorantagentguide.agentitem.dbtable.EntityAgent
import java.lang.IllegalStateException

object VAGDatabase {
    private var hasInitialized: Boolean = false
    private lateinit var internalDataBase: InternalRoomDB

    fun getAgentDAO(): DAOAgent {
        if (!hasInitialized) throw IllegalStateException("VAGDatabase has not been initialized.")
        return internalDataBase.agentDAO()
    }

    fun initialize(context: Context) {
        if (!hasInitialized) {
            hasInitialized = true
            internalDataBase = Room.databaseBuilder(
                context,
                InternalRoomDB::class.java,
                "valorantagentguide-database"
            ).createFromAsset("database/valorant-agent-initial-db.db").build()
        } else {
            throw IllegalStateException("VAGDatabase is already initialized. This should happen once")
        }
    }

    @Database(version = 1, entities = [EntityAgent::class], exportSchema = true)
    abstract class InternalRoomDB : RoomDatabase() {
        abstract fun agentDAO(): DAOAgent
    }
}