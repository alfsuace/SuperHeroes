package com.alfsuace.superheroes.superheroes.data.remote

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.domain.Connections

interface ConnectionsRemoteDataRepository {
    suspend fun getConnections(id: Int): Either<ErrorApp, Connections>
}
