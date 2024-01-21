package com.alfsuace.superheroes.superheroes.data.local.xml


import android.content.Context
import com.alfsuace.superheroes.app.errors.Either
import com.alfsuace.superheroes.app.errors.ErrorApp
import com.alfsuace.superheroes.app.errors.left
import com.alfsuace.superheroes.app.errors.right
import com.alfsuace.superheroes.app.extensions.Serializer
import com.alfsuace.superheroes.superheroes.data.local.SuperHeroLocalDataRepository
import com.alfsuace.superheroes.superheroes.domain.SuperHero

class SuperHeroXmlLocalDataSource(
    private var context: Context,
    private var serializer: Serializer
) : SuperHeroLocalDataRepository {

    private val sharedPref = context.getSharedPreferences("SuperHeroes", Context.MODE_PRIVATE)

    override fun saveSuperHeroes(superHeroes: List<SuperHero>): Either<ErrorApp, Boolean> {
        return try {
            superHeroes.map { superHeroe ->
                sharedPref.edit().apply {
                    putString(
                        superHeroe.id.toString(),
                        serializer.toJson(superHeroe, SuperHero::class.java)
                    )
                }.apply()
            }
            true.right()
        } catch (ex: Exception) {
            ErrorApp.UnknownError.left()
        }
    }

    override fun getSuperHeroes(): Either<ErrorApp, List<SuperHero>> {
        return try {
            sharedPref.all.map {
                serializer
                    .fromJson(it.value as String, SuperHero::class.java)

            }.right()
        } catch (ex: Exception) {
            ErrorApp.UnknownError.left()
        }
    }


    override fun getSuperHeroId(id: Int): Either<ErrorApp, SuperHero> {
        return try {
            serializer
                .fromJson(sharedPref.getString(id.toString(), "")!!, SuperHero::class.java)
                .right()
        } catch (ex: Exception) {
            ErrorApp.UnknownError.left()
        }
    }


}
