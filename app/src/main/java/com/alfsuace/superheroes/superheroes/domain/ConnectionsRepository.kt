package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

interface ConnectionsRepository {
    suspend fun getConnections(id: Int): Either<ErrorApp, Connections>
}