package com.alfsuace.superheroes.superheroes.data.local

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.domain.SuperHero

interface SuperHeroLocalDataRepository {
    fun saveSuperHeroes(superHeroes: List<SuperHero>): Either<ErrorApp, Boolean>
    fun getSuperHeroes(): Either<ErrorApp, List<SuperHero>>
    fun getSuperHeroId(id: Int): Either<ErrorApp, SuperHero>
}