package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

interface PowerStatsRepository {
    suspend fun getPowerStats(id: Int): Either<ErrorApp, PowerStats>
}