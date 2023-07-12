package com.sumincourse.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.sumincourse.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.sumincourse.firstcomposeproject.ui.theme.InstagramProfileCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            Test(viewModel)
        }
    }
}

@Composable
private fun Test(viewModel: MainViewModel) {
    FirstComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            val models = viewModel.models.observeAsState(listOf())

            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(models.value) {
                    InstagramProfileCard(
                        model = it,
                        onFollowedButtonClickListener = { viewModel.changeFollowingStatus(it) }
                    )

                }
            }
        }
    }
}





