package com.alfsuace.superheroes.superheroes.data

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.superheroes.data.local.SuperHeroLocalDataRepository
import com.alfsuace.superheroes.superheroes.data.remote.SuperHeroRemoteDataRepository
import com.alfsuace.superheroes.superheroes.domain.SuperHero
import com.alfsuace.superheroes.superheroes.domain.SuperHeroRepository

class SuperHeroDataRepository(
    private var localSource: SuperHeroLocalDataRepository,
    private var remoteSource: SuperHeroRemoteDataRepository
) : SuperHeroRepository {
    override suspend fun getSuperHeroes(): Either<ErrorApp, List<SuperHero>> {
        var localSuperHeroes = localSource.getSuperHeroes()

        return if(localSuperHeroes.isLeft() || localSuperHeroes.get().isEmpty()  ) {
            localSuperHeroes = remoteSource.getSuperHeroes()

            remoteSource.getSuperHeroes().map {
                localSource.saveSuperHeroes(it)
            }
            localSuperHeroes

        } else {
            localSuperHeroes
        }
    }

    override suspend fun getSuperHeroId(id: Int): Either<ErrorApp, SuperHero> {
        var superHero = localSource.getSuperHeroId(id)

        return if (superHero.isLeft()) {
            superHero = remoteSource.getSuperHeroId(id)
            superHero

        } else {
            superHero
        }
    }
}