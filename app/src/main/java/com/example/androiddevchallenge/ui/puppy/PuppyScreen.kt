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
package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.puppies.PuppiesRepository
import com.example.androiddevchallenge.data.puppies.impl.randomPuppy
import com.example.androiddevchallenge.model.Puppy

@Composable
fun PuppyScreen(
    puppiesRepository: PuppiesRepository,
    puppyId: String?
) {
    val puppy = puppyId?.let { puppiesRepository.getPuppy(puppyId = it) }
    if (puppy != null)
        PuppyDetail(puppy = puppy)
    else
        NoPuppyFound()
}

@Preview
@Composable
fun NoPuppyFound() {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Sorry, we could not found this Puppy",
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun PuppyDetail(puppy: Puppy) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
    ) {
        val imageModifier = Modifier
            .heightIn(min = 100.dp, max = 500.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
        Image(
            painterResource(id = puppy.imageId),
            contentDescription = null,
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = puppy.name,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = puppy.breed.str,
            style = MaterialTheme.typography.subtitle1,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = puppy.description,
            style = MaterialTheme.typography.body1
        )
    }
}

@Preview
@Composable
fun PuppyDetailPreview() {
    PuppyDetail(puppy = randomPuppy())
}
