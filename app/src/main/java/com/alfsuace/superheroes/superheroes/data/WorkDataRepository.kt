package com.alfsuace.superheroes.superheroes.data

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.data.remote.WorkRemoteDataRepository
import com.alfsuace.superheroes.superheroes.domain.Work
import com.alfsuace.superheroes.superheroes.domain.WorkRepository

class WorkDataRepository(

    private var remoteSource: WorkRemoteDataRepository
) : WorkRepository {

    override suspend fun getWorkId(id: Int): Either<ErrorApp, Work> {
        return remoteSource.getWorkId(id)
    }
}