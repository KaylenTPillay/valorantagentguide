package co.za.kaylen.pillay.valorantagentguide.agentitem.dbtable

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agent")
data class EntityAgent(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val name: String,
    val type: String,
    val thumbnailURL: String,
    val bodyThumbnailURL: String
)