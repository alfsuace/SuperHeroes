package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

interface BiographyRepository {
    suspend fun getBiography(id: Int): Either<ErrorApp, Biography>
}