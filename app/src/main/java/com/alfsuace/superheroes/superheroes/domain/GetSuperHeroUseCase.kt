package com.alfsuace.superheroes.superheroes.domain

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp

class GetSuperHeroUseCase(
    private val superHeroRepository: SuperHeroRepository,
    private val biographyRepository: BiographyRepository,
    private val powerStatsRepository: PowerStatsRepository,
    private val connectionsRepository: ConnectionsRepository
) {
    suspend operator fun invoke(id: Int): Either<ErrorApp, SuperHeroDetail> {
        val superHero = superHeroRepository.getSuperHeroId(id)

        val detail = superHero.map {
            val biography = biographyRepository.getBiography(id).get()
            val powerStats = powerStatsRepository.getPowerStats(id).get()
            val connections = connectionsRepository.getConnections(id).get()

            SuperHeroDetail(
                it.id,
                it.name,
                it.getImageLg(),
                it.image,
                biography.fullName,
                connections.affiliation,
                powerStats.intelligence,
                powerStats.speed,
                powerStats.combat
            )
        }
        return detail
    }
}