package com.example.myapplicationm3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun previewItem(){
    cardItemView(img = R.drawable.appbrewerybanner, title = "Programming", subtitle = "Learn Programing Language")
}
@Composable
fun cardItemView(img:Int,title:String,subtitle:String){
Card(elevation = CardDefaults.cardElevation(), modifier = Modifier.padding(8.dp)) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
        Image(painter = painterResource(id = img), contentDescription = "",
        modifier = Modifier
            .size(48.dp)
            .padding(8.dp)
            .weight(.2f))
        Column(modifier = Modifier.weight(.8f)) {
            Text(text = title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
            fontSize = 16.sp)
            Text(text = subtitle,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
            )
        }
    }
}
}