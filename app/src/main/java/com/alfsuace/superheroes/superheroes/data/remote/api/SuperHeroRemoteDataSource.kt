package com.alfsuace.superheroes.superheroes.data.remote.api

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.data.remote.SuperHeroRemoteDataRepository
import com.alfsuace.superheroes.superheroes.domain.SuperHero

class SuperHeroRemoteDataSource : SuperHeroRemoteDataRepository {
    private val apiClient = ApiClient()

    override suspend fun getSuperHeroes(): Either<ErrorApp, List<SuperHero>> =
        apiClient.getSuperHeroes().map {
            it.subList(0, 20).map { hero ->
                hero.toDomain()
            }
        }

    override suspend fun getSuperHeroId(id: Int): Either<ErrorApp, SuperHero> =
        apiClient.getSuperHeroeId(id).map {
            it.toDomain()
        }

}
