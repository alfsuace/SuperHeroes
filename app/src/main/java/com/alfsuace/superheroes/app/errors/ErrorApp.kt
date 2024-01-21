package com.alfsuace.superheroes.app.errors

sealed class ErrorApp {
    object UnknownError: ErrorApp()
    object InternetError: ErrorApp()
    object DataError: ErrorApp()
}