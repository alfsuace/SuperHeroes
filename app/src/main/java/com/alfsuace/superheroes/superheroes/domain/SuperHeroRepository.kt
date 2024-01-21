package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

interface SuperHeroRepository {
    suspend fun getSuperHeroes(): Either<ErrorApp, List<SuperHero>>
    suspend fun getSuperHeroId(id: Int): Either<ErrorApp, SuperHero>
}