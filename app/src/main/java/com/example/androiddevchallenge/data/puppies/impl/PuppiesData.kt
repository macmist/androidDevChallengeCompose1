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
package com.example.androiddevchallenge.data.puppies.impl

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Puppy
import java.util.UUID

// Random data for a random list of puppies

val names: List<String> = listOf(
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

val superlatives: List<String> = listOf(
    "funniest",
    "most awesome",
    "coolest",
    "cutest",
    "most unique",
    "cleverest",
    "most spirited",
    "most likely to be Instagram famous",
    "kindest"
)

const val descriptionTemplate: String = "Meet %s.\n" +
    "%s is the %s dog in the whole world." +
    "We know you'll love to have %s around.\n" +
    "Don't wait, adopt %s now!"

fun randomDescription(name: String, gender: String): String {
    return descriptionTemplate.format(name, name, superlatives.random(), gender, gender)
}

val chihuahuaImages: List<Int> = listOf(
    R.drawable.chihuahua1,
    R.drawable.chihuahua2,
    R.drawable.chihuahua3
)

val bassetImages: List<Int> = listOf(
    R.drawable.basset1,
    R.drawable.basset2,
    R.drawable.basset3
)

val airedaleImages: List<Int> = listOf(
    R.drawable.airedale1,
    R.drawable.airedale2,
    R.drawable.airedale3
)

val borzoiImages: List<Int> = listOf(
    R.drawable.borzoi1,
    R.drawable.borzoi2,
    R.drawable.borzoi3,
)

val cairnImages: List<Int> = listOf(
    R.drawable.cairn1,
    R.drawable.cairn2,
    R.drawable.cairn3,
)

val genderStrings: List<String> = listOf(
    "him",
    "her"
)

fun generateID(): String {
    return UUID.randomUUID().toString()
}

fun randomPuppy(): Puppy {
    val name = names.random()
    val gender = genderStrings.random()
    val breed = Breed.values().toList().shuffled().first()
    return Puppy(
        id = generateID(),
        name = name,
        description = randomDescription(name, gender = gender),
        breed = breed,
        imageId = getCorrectImageDrawable(breed = breed)
    )
}

fun getCorrectImageDrawable(breed: Breed): Int {
    when (breed) {
        Breed.Chihuahua -> return chihuahuaImages.random()
        Breed.Basset -> return bassetImages.random()
        Breed.Airedale -> return airedaleImages.random()
        Breed.Borzoi -> return borzoiImages.random()
        Breed.Cairn -> return cairnImages.random()
        else -> return bassetImages.random()
    }
}

val puppies: List<Puppy> = MutableList(50) { randomPuppy() }
