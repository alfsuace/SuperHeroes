package com.alfsuace.superheroes.superheroes.data.remote.api

import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.app.errors.left
import com.alfsuace.superheroes.app.errors.right
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val urlEndPoint = "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/"
    private var apiEndPoint: ApiServices

    init {
        apiEndPoint = buildApiEndPoint()
    }

    private fun buildClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(urlEndPoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildApiEndPoint(): ApiServices {
        return buildClient().create(ApiServices::class.java)

    }

    suspend fun getSuperHeroes(): Either<ErrorApp, List<SuperHeroApiModel>> {
        val response = apiEndPoint.getSuperHeroes()

        return if (response.isSuccessful) {
            response.body()!!.right()
        } else {
            ErrorApp.UnknownError.left()
        }
    }

    suspend fun getSuperHeroeId(id: Int): Either<ErrorApp, SuperHeroApiModel> {
        val response = apiEndPoint.getSuperHeroId(id)

        return if (response.isSuccessful) {
            response.body()!!.right()
        } else {
            ErrorApp.UnknownError.left()
        }
    }

    suspend fun getBiography(id: Int): Either<ErrorApp, BiographyApiModel> {
        val response = apiEndPoint.getBiography(id)

        return if (response.isSuccessful) {
            response.body()!!.right()
        } else {
            ErrorApp.UnknownError.left()
        }
    }

    suspend fun getWork(id: Int): Either<ErrorApp, WorkApiModel> {
        val response = apiEndPoint.getWork(id)

        return if (response.isSuccessful) {
            response.body()!!.right()
        } else {
            ErrorApp.UnknownError.left()
        }
    }

    suspend fun getPowerStats(id: Int): Either<ErrorApp, PowerStatsApiModel> {
        val response = apiEndPoint.getPowerStats(id)

        return if (response.isSuccessful) {
            response.body()!!.right()
        } else {
            ErrorApp.UnknownError.left()
        }
    }

    suspend fun getConnections(id: Int): Either<ErrorApp, ConnectionsApiModel> {
        val response = apiEndPoint.getConnections(id)

        return if (response.isSuccessful) {
            response.body()!!.right()
        } else {
            ErrorApp.UnknownError.left()
        }
    }
}