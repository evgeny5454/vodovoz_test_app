package com.evgeny_minaenkov.vodovozapp

sealed class Screen(var route: String) {
    object MainScreen : Screen("main_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}