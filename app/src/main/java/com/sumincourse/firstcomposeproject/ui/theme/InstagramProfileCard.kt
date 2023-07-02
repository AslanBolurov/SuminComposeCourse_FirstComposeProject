package com.sumincourse.firstcomposeproject.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun InstagramProfileCard() {

    Card(
        shape = RoundedCornerShape(4.dp,4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        border = BorderStroke(1.dp, color = Color.Black),



    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)

            ,
            horizontalArrangement = Arrangement.SpaceEvenly,
//        horizontalArrangement = Arrangement.SpaceBetween
//        horizontalArrangement = Arrangement.SpaceAround
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .background(color = Color.Yellow)
            )

            TwoBoxes()

            TwoBoxes()

            TwoBoxes()


        }
    }
}

@Composable
private fun TwoBoxes() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(color = Color.Blue)
        ) {


        }
        Box(
            modifier = Modifier
                .size(25.dp)
                .background(color = Color.Red)
        ) {


        }
    }
}