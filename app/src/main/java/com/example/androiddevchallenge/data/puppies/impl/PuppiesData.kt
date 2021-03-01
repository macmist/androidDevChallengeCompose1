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

// Create a list of puppies

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

val chihuahuaImages: List<Int> = listOf(
    R.drawable.chihuahua1,
    R.drawable.chihuahua2,
    R.drawable.chihuahua3
)

fun generateID(): String {
    return UUID.randomUUID().toString()
}

fun randomChihuahua(): Puppy {
    return Puppy(
        id = generateID(),
        name = names.random(),
        description = "This is a good doggo",
        breed = Breed.Chihuahua,
        imageId = chihuahuaImages.random(),
    )
}

val puppies: List<Puppy> = listOf(
    randomChihuahua(),
    randomChihuahua(),
    randomChihuahua()
)
