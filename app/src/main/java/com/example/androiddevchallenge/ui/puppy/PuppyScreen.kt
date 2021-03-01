package com.example.androiddevchallenge.ui.puppy

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.androiddevchallenge.data.puppies.PuppiesRepository

@Composable
fun PuppyScreen(
    navController: NavController,
    puppiesRepository: PuppiesRepository,
    puppyId: String?) {
    Text(text = "coucou " + puppyId)
}