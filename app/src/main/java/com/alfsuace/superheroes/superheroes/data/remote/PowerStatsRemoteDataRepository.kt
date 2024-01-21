package com.alfsuace.superheroes.superheroes.data.remote

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.domain.Biography

interface PowerStatsRemoteDataRepository {
    suspend fun getBiography(id: Int): Either<ErrorApp, Biography>
}