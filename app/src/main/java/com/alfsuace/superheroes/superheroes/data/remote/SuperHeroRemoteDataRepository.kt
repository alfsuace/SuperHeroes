package com.alfsuace.superheroes.superheroes.data.remote

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.domain.SuperHero

interface SuperHeroRemoteDataRepository {
    suspend fun getSuperHeroes(): Either<ErrorApp, List<SuperHero>>
    suspend fun getSuperHeroId(id: Int): Either<ErrorApp, SuperHero>
}