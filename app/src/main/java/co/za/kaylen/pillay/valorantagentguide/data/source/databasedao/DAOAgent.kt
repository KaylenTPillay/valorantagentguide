package co.za.kaylen.pillay.valorantagentguide.data.source.databasedao

import androidx.room.Dao
import androidx.room.Query
import co.za.kaylen.pillay.valorantagentguide.data.model.DTOAgent

@Dao
interface DAOAgent {
    @Query("SELECT * FROM agent")
    suspend fun getAgents(): List<DTOAgent>
}