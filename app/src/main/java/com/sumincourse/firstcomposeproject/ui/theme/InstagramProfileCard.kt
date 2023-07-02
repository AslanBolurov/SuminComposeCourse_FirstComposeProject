package com.sumincourse.firstcomposeproject.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun InstagramProfileCard() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(8.dp)

        ,
        horizontalArrangement = Arrangement.SpaceEvenly
//        horizontalArrangement = Arrangement.SpaceBetween
//        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Box(
            modifier = Modifier
//            .width(50.dp)
//            .height(50.dp)
                .size(50.dp)
                .background(color = Color.Yellow)
        ) {


        }
        Box(
            modifier = Modifier
//            .width(50.dp)
//            .height(50.dp)
                .size(50.dp)
                .background(color = Color.Green)
        ) {


        }
        Box(
            modifier = Modifier
//            .width(50.dp)
//            .height(50.dp)
                .size(50.dp)
                .background(color = Color.Blue)
        ) {


        }
        Box(
            modifier = Modifier
//            .width(50.dp)
//            .height(50.dp)
                .size(50.dp)
                .background(color = Color.Red)
        ) {


        }

    }


}