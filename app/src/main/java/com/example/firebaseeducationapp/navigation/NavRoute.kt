package com.example.firebaseeducationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebaseeducationapp.screens.Add
import com.example.firebaseeducationapp.screens.Main
import com.example.firebaseeducationapp.screens.Note
import com.example.firebaseeducationapp.screens.Start

sealed class NavRoute(val route: String) {
    object StartScreen : NavRoute("startScreen")
    object MainScreen : NavRoute("mainScreen")
    object AddScreen : NavRoute("addScreen")
    object NoteScreen : NavRoute("noteScreen")

}

@Composable
fun NotesNavHost() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = NavRoute.StartScreen.route) {
        composable(NavRoute.StartScreen.route) { Start(navController = navHostController) }
        composable(NavRoute.MainScreen.route) { Main(navController = navHostController) }
        composable(NavRoute.AddScreen.route) { Add(navController = navHostController) }
        composable(NavRoute.NoteScreen.route) { Note(navController = navHostController) }
    }

}