package com.alfsuace.superheroes.superheroes.data.remote.api

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.data.remote.ConnectionsRemoteDataRepository
import com.alfsuace.superheroes.superheroes.domain.Connections

class ConnectionsRemoteDataSource : ConnectionsRemoteDataRepository {
    private val apiClient = ApiClient()

    override suspend fun getConnections(id: Int): Either<ErrorApp, Connections> =
        apiClient.getConnections(id).map {
            it.toDomain()
        }
}