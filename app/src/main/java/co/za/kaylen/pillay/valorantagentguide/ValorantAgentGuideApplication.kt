package co.za.kaylen.pillay.valorantagentguide

import android.app.Application
import co.za.kaylen.pillay.valorantagentguide.utils.database.VAGDatabase

@Suppress("unused")
class ValorantAgentGuideApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        VAGDatabase.initialize(this)
    }
}