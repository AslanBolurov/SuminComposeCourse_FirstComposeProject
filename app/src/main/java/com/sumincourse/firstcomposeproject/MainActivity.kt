package com.sumincourse.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.sumincourse.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import com.sumincourse.firstcomposeproject.ui.theme.InstagramProfileCard
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setContent {
            Test(viewModel)
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Test(viewModel: MainViewModel) {
    FirstComposeProjectTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            val models = viewModel.models.observeAsState(listOf())

            LazyColumn {


                items(models.value, key = { it.id}) {

                    val dismissState = rememberDismissState()

                    if (dismissState.isDismissed(DismissDirection.EndToStart)){
                        viewModel.delete(it)
                    }

                    SwipeToDismiss(
                        state = dismissState,
                        directions = setOf(DismissDirection.EndToStart),
                        background = {
                            Box(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxSize()
                                    .background(Color.Red.copy(alpha = 0.5f)),
                                contentAlignment = Alignment.CenterEnd
                            ) {
                                Text(
                                    text = "Delete item",
                                    color = Color.White,
                                    fontSize = 24.sp,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    ) {
                        InstagramProfileCard(
                            model = it,
                            onFollowedButtonClickListener = { viewModel.changeFollowingStatus(it) }
                        )
                    }
                }
            }
        }
    }
}





