package co.za.kaylen.pillay.valorantagentguide.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "agent")
data class DTOAgent(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    val name: String,
    val type: String,
    val thumbnailURL: String,
    val bodyThumbnailURL: String
)