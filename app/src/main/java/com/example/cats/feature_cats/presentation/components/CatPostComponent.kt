package com.example.cats.feature_cats.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cats.feature_cats.data.remote.dto.Data
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun CatPostComponent(modifier: Modifier = Modifier, cat: Data) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SliderGallery(images = cat.images!!)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)) {
                    append("${cat.account_url}: ")
                }
                withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp)) {
                    append(cat.title)
                }
            }, Modifier.fillMaxWidth()
        )
    }
}

