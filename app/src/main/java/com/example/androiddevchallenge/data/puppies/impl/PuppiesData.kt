package com.example.androiddevchallenge.data.puppies.impl

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Puppy
import java.util.*

// Create a list of puppies

val names : List<String> = listOf(
    "Stone",
    "Tilly",
    "Mocha",
    "King",
    "Atlas",
    "Kiri",
    "Sam",
    "Biscuit",
    "Brooklyn",
    "Carmen",
    "Buddy",
    "Chewy",
    "Daisy",
    "Kennedy",
    "Juno",
    "Koda",
    "Loki",
    "Morty",
    "Luna",
    "Rusty",
    "Pumpkin"
)

val chihuahuaImages: List<Int> = listOf(
    R.drawable.chihuahua1,
    R.drawable.chihuahua2,
    R.drawable.chihuahua3
)

fun generateID() : String {
    return UUID.randomUUID().toString()
}

fun randomChihuahua() : Puppy {
    return Puppy(
        id = generateID(),
        name = names.random(),
        description = "This is a good doggo",
        breed = Breed.Chihuahua,
        imageId = chihuahuaImages.random(),
    )
}

val puppies : List<Puppy> = listOf(
    randomChihuahua(),
    randomChihuahua(),
    randomChihuahua()
)