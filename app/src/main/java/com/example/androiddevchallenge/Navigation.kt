package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.puppies.PuppiesRepository
import com.example.androiddevchallenge.data.puppies.impl.PuppiesRepositoryImpl
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.puppy.PuppyScreen

const val HOME_SCREEN = "home"
const val PUPPY_SCREEN = "puppy"
const val PUPPY_SCREEN_ARG = "puppy/{puppyId}"

@Composable
fun Navigation(puppiesRepository: PuppiesRepository) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME_SCREEN) {
        composable(HOME_SCREEN) { HomeScreen(navController = navController, puppiesRepository = puppiesRepository)}
        composable(PUPPY_SCREEN_ARG) { navBackStackEntry -> PuppyScreen(
            navController = navController,
            puppiesRepository = puppiesRepository,
            puppyId = navBackStackEntry.arguments?.getString("puppyId")
        ) }
    }
}

@Preview
@Composable
fun NavigationPreview() {
    Navigation(PuppiesRepositoryImpl())
}