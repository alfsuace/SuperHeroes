package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

interface WorkRepository {

    suspend fun getWork(id: Int): Either<ErrorApp, Work>
}