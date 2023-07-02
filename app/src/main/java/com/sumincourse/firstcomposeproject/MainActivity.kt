package com.sumincourse.firstcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sumincourse.firstcomposeproject.ui.theme.FirstComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UserInfo(name="Aslan", age=31)

        }
    }
}


@Composable
fun UserInfo(name: String, age:Int) {
    Text(
        text = "Hello $name! You are $age years old."
    )
}

