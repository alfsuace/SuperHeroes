package com.alfsuace.superheroes.superheroes.data.remote.api

import com.alfsuace.superheroes.superheroes.domain.Biography
import com.alfsuace.superheroes.superheroes.domain.Connections
import com.alfsuace.superheroes.superheroes.domain.PowerStats
import com.alfsuace.superheroes.superheroes.domain.SuperHero
import com.alfsuace.superheroes.superheroes.domain.Work

fun SuperHeroApiModel.toDomain(): SuperHero {
    return SuperHero(
        this.id,
        this.name,
        listOf(this.image.xs, this.image.sm, this.image.md, this.image.lg)
    )
}

fun BiographyApiModel.toDomain(): Biography {
    return Biography(
        this.fullName
    )
}

fun WorkApiModel.toDomain(): Work {
    return Work(
        this.occupation
    )
}

fun PowerStatsApiModel.toDomain(): PowerStats {
    return PowerStats(
        this.intelligence,
        this.speed,
        this.combat
    )
}

fun ConnectionsApiModel.toDomain(): Connections {
    return Connections(
        this.affiliation
    )
}