package com.alfsuace.superheroes.superheroes.domain

data class SuperHero(
    val id: Int,
    val name: String,
    val image: List<String>
){
    fun getImageXs() : String = image[0]
    fun getImageSm() : String = image[1]
    fun getImageMd() : String = image[2]
    fun getImageLg() : String = image[3]
}

data class Biography(
    val fullName: String
)

data class Work(
    val occupation: String
)

data class PowerStats(
    val intelligence: Int,
    val speed: Int,
    val combat: Int
)

data class Connections(
    val affiliation: String
)

data class SuperHeroDetail(
    val id: Int,
    val name: String,
    val bannerImage: String,
    val images: List<String>,
    val fullName: String,
    val affiliation: String,
    val intelligence: Int,
    val speed: Int,
    val combat: Int
)

data class SuperHeroFeed(
    val id: Int,
    val name: String,
    val image: String,
    val fullName: String,
    val occupation: String
)