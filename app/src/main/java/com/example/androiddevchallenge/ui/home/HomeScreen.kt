package com.example.androiddevchallenge.ui.home

import android.view.Gravity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.puppies.PuppiesRepository
import com.example.androiddevchallenge.model.Puppy
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.PUPPY_SCREEN
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.puppies.impl.puppies
import com.example.androiddevchallenge.data.puppies.impl.randomChihuahua


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
            puppy -> PuppyItem(puppy = puppy) { navController.navigate("$PUPPY_SCREEN/${puppy.id}") }
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
    Column (
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
            modifier = Modifier.align(Alignment.CenterHorizontally))
    }
}

@Preview
@Composable
fun PuppyPreview() {
    PuppyItem(puppy = randomChihuahua(), onClick = {  })
}