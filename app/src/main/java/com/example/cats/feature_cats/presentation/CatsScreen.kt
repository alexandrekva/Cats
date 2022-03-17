package com.example.cats.feature_cats.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cats.R
import com.example.cats.feature_cats.presentation.components.CatPostComponent
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.flow.collectLatest

@ExperimentalPagerApi
@Composable
fun CatsScreen(catsViewModel: CatsViewModel = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        catsViewModel.eventFlow.collectLatest { event ->
            when (event) {
                is CatsViewModel.UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (catsViewModel.initialState.value) {
                Image(
                    modifier = Modifier
                        .size(180.dp)
                        .clickable { catsViewModel.getCats() },
                    painter = painterResource(id = R.drawable.ic_cat_silhouette),
                    contentDescription = "App Cat Icon",
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = stringResource(id = R.string.cat_surprise),
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.Center,
                )
            } else {
                if (catsViewModel.isLoading.value) {
                    CircularProgressIndicator(modifier = Modifier.size(80.dp))
                } else {
                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(catsViewModel.cats) { cat ->
                            if (!cat.images.isNullOrEmpty()) CatPostComponent(cat = cat)
                        }
                    }
                }
            }
        }
    }

}

@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PreviewCatsScreen() {
    CatsScreen()
}