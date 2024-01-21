package com.alfsuace.superheroes.superheroes.data.remote

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.domain.Work

interface WorkRemoteDataRepository {
        suspend fun getWorkId(id: Int): Either<ErrorApp, Work>

}
