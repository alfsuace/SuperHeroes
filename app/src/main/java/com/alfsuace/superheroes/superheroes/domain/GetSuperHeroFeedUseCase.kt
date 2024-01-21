package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

class GetSuperHeroFeedUseCase(
    private val superHeroRepository: SuperHeroRepository,
    private val biographyRepository: BiographyRepository,
    private val workRepository: WorkRepository
) {

    suspend operator fun invoke(): Either<ErrorApp, List<SuperHeroFeed>> {
        val superHeroes = superHeroRepository.getSuperHeroes()


        val feed = superHeroes.map {
            it.map { superHero ->
                val work = workRepository.getWork(superHero.id).get()
                val biography = biographyRepository.getBiography(superHero.id).get()

                SuperHeroFeed(
                    superHero.id,
                    superHero.name,
                    superHero.getImageLg(),
                    biography.fullName,
                    work.occupation
                )
            }
        }
        return feed
    }
}