package com.example.androiddevchallenge.data.puppies.impl

import com.example.androiddevchallenge.data.puppies.PuppiesRepository
import com.example.androiddevchallenge.model.Puppy

class PuppiesRepositoryImpl : PuppiesRepository {

    override fun getPuppies(): List<Puppy> {
        return puppies
    }

    override fun getPuppy(puppyId: String): Puppy? {
        return puppies.firstOrNull {
            it.id == puppyId
        }
    }
}