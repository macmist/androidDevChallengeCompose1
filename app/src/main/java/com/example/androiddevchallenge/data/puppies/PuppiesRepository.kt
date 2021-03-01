package com.example.androiddevchallenge.data.puppies

import com.example.androiddevchallenge.model.Puppy

interface PuppiesRepository {
    fun getPuppy(puppyId: String) : Puppy?

    fun getPuppies(): List<Puppy>
}