package com.alfsuace.superheroes.superheroes.data.remote.api

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.data.remote.WorkRemoteDataRepository
import com.alfsuace.superheroes.superheroes.domain.Work

class WorkRemoteDataSource : WorkRemoteDataRepository {

    private val apiClient = ApiClient()

    override suspend fun getWorkId(id: Int): Either<ErrorApp, Work> =
        apiClient.getWork(id).map {
            it.toDomain()
        }
}