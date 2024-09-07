package com.example.jetcompose.ui.theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetcompose.R


@Preview
@Composable
fun blogCategory(){
    Card(elevation = 8.dp, modifier = androidx.compose.ui.Modifier.padding(8.dp)) {
        Row() {
            Image(painter = painterResource(id = R.drawable.diamond_app_icon) , contentDescription ="" )
            Column() {
                Text(text = "Programming")
                Text(text = "Learn Different Language")
            }
        }
    }
}