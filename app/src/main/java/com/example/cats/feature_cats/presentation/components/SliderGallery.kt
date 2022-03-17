package com.example.cats.feature_cats.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cats.R
import com.example.cats.feature_cats.data.remote.dto.Image
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@ExperimentalPagerApi
@Composable
fun SliderGallery(images: List<Image>) {
    val pagerState = rememberPagerState()

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(count = images.size, state = pagerState) { position ->
            AsyncImage(
                model = images[position].link,
                contentDescription = "image",
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_baseline_insert_photo_24),
                error = painterResource(id = R.drawable.ic_baseline_error_outline_24),
                modifier = Modifier.height(300.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalPagerIndicator(pagerState = pagerState)
    }
}