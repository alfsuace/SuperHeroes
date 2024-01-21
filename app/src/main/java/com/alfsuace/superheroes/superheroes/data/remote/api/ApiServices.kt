package com.alfsuace.superheroes.superheroes.data.remote.api


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("all.json")
    suspend fun getSuperHeroes(): Response<List<SuperHeroApiModel>>

    @GET("id/{id}.json")
    suspend fun getSuperHeroId(@Path("id") id: Int): Response<SuperHeroApiModel>

    @GET("biography/{id}.json")
    suspend fun getBiography(@Path("id") id: Int): Response<BiographyApiModel>

    @GET("work/{id}.json")
    suspend fun getWork(@Path("id") id: Int): Response<WorkApiModel>

    @GET("powerstats/{id}.json")
    suspend fun getPowerStats(@Path("id") id: Int): Response<PowerStatsApiModel>

    @GET("connections/{id}.json")
    suspend fun getConnections(@Path("id") id: Int): Response<ConnectionsApiModel>
}