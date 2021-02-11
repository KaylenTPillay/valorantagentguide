package co.za.kaylen.pillay.valorantagentguide.data.repository

import co.za.kaylen.pillay.valorantagentguide.data.model.DTOAgent

interface RepositoryAgents {
    suspend fun getAgents(): List<DTOAgent>
}