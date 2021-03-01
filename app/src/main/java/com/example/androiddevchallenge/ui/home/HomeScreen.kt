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
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.PUPPY_SCREEN
import com.example.androiddevchallenge.data.puppies.PuppiesRepository
import com.example.androiddevchallenge.data.puppies.impl.puppies
import com.example.androiddevchallenge.data.puppies.impl.randomChihuahua
import com.example.androiddevchallenge.model.Puppy

@Composable
fun HomeScreen(
    navController: NavController,
    puppiesRepository: PuppiesRepository
) {
    val puppies = puppiesRepository.getPuppies()
    PuppyList(puppies = puppies, navController = navController)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppyList(puppies: List<Puppy>, navController: NavController) {
    LazyVerticalGrid(cells = GridCells.Fixed(2)) {
        items(puppies) {
            puppy ->
            PuppyItem(puppy = puppy) { navController.navigate("$PUPPY_SCREEN/${puppy.id}") }
        }
    }
}

@Preview
@Composable
fun PuppyListPreview() {
    PuppyList(puppies = puppies, navController = rememberNavController())
}

@Composable
fun PuppyItem(puppy: Puppy, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val imageModifier = Modifier
            .heightIn(min = 100.dp)
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
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview
@Composable
fun PuppyPreview() {
    PuppyItem(puppy = randomChihuahua(), onClick = { })
}
