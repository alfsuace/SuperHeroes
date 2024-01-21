package com.alfsuace.superheroes.superheroes.data.remote.api

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.data.remote.BiographyRemoteDataRepository
import com.alfsuace.superheroes.superheroes.domain.Biography

class BiographyRemoteDataSource: BiographyRemoteDataRepository {
    private val apiClient = ApiClient()

    override suspend fun getBiography(id: Int): Either<ErrorApp, Biography> =
        apiClient.getBiography(id).map {
        it.toDomain()
    }
}