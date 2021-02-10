package co.za.kaylen.pillay.valorantagentguide.agentitem.dao

import androidx.room.Dao
import androidx.room.Query
import co.za.kaylen.pillay.valorantagentguide.agentitem.dbtable.EntityAgent

@Dao
interface DAOAgent {
    @Query("SELECT * FROM agent")
    suspend fun getAgents(): List<EntityAgent>
}