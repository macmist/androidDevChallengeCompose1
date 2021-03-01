package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Puppy(
    val id: String,
    val name: String,
    val description: String,
    val breed: Breed,
    @DrawableRes val imageId: Int
)


enum class Breed {
    Chihuahua,
    Dachshund,
    Dalmatian,
    Poodle
}
