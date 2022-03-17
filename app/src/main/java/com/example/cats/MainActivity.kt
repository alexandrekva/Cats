package com.example.cats

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.cats.feature_cats.presentation.CatsViewModel
import com.example.cats.feature_cats.presentation.components.CatPostComponent
import com.example.cats.ui.theme.CatsTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val catsViewModel: CatsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        catsViewModel.getCats()

        setContent {
            CatsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        if (!catsViewModel.isLoading.value) {
                            LazyColumn() {
                                items(catsViewModel.cats) { cat ->
                                    if (!cat.images.isNullOrEmpty()) CatPostComponent(cat = cat)
                                    Divider(color = Color.Black)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


