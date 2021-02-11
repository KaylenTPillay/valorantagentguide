package co.za.kaylen.pillay.valorantagentguide.domain.usecase.factory

import co.za.kaylen.pillay.valorantagentguide.data.repository.impl.RepositoryAgentsImpl
import co.za.kaylen.pillay.valorantagentguide.domain.usecase.UseCaseAgentsGet

object UseCaseFactory {
    fun createUseCaseAgentGet(): UseCaseAgentsGet {
        return UseCaseAgentsGet(repository = RepositoryAgentsImpl())
    }
}