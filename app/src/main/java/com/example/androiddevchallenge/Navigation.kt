/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        composable(HOME_SCREEN) { HomeScreen(navController = navController, puppiesRepository = puppiesRepository) }
        composable(PUPPY_SCREEN_ARG) { navBackStackEntry ->
            PuppyScreen(
                puppiesRepository = puppiesRepository,
                puppyId = navBackStackEntry.arguments?.getString("puppyId")
            )
        }
    }
}

@Preview
@Composable
fun NavigationPreview() {
    Navigation(PuppiesRepositoryImpl())
}
