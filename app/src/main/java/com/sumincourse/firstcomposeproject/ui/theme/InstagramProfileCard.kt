package com.sumincourse.firstcomposeproject.ui.theme

import android.widget.ExpandableListView.OnChildClickListener
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sumincourse.firstcomposeproject.InstagramModel
import com.sumincourse.firstcomposeproject.MainViewModel
import com.sumincourse.firstcomposeproject.R


@Composable
fun InstagramProfileCard(
    model: InstagramModel,
    onFollowedButtonClickListener: (InstagramModel) -> Unit
) {

    Card(

        modifier = Modifier.padding(8.dp),

        shape = RoundedCornerShape(4.dp, 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        border = BorderStroke(
            1.dp,
            color = MaterialTheme.colorScheme.onBackground
        ),

        ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            InstaHead()
            Text(
                text = "INstagram ${model.id }",
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive
            )
            Text(text = "${model.title}", fontSize = 14.sp)
            Text(text = "Telegram/t.me/Aslan_Javasky", fontSize = 14.sp)

            FollowButton(
                isFollowed = model.isFollowed
            ) {
                onFollowedButtonClickListener(model)
            }

        }
    }
}

@Composable
private fun FollowButton(
    isFollowed: Boolean,
    clickListener: () -> Unit
) {
    Button(
        onClick = {
            clickListener()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isFollowed) {
                MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
            } else {
                MaterialTheme.colorScheme.primary
            }
        )
    ) {
        val text = if (isFollowed) {
            "Unfollow"
        } else {
            "Follow"
        }
        Text(text = text)
    }
}

@Composable
private fun InstaHead() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
//            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
//        horizontalArrangement = Arrangement.SpaceBetween
//        horizontalArrangement = Arrangement.SpaceAround
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painterResource(R.drawable.ic_instagram),
            contentDescription = "image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color.White)
                .padding(8.dp)
        )

        UserStatistics("Posts", "6,950")
        UserStatistics("Followers", "436")
        UserStatistics("Following", "76")
    }
}

@Composable
private fun UserStatistics(
    title: String,
    value: String
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {

        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )



        Text(text = title, fontWeight = FontWeight.Bold)
    }
}
