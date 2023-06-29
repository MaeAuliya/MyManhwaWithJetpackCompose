package com.example.mymanhwawithcompose.ui.profile

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymanhwawithcompose.R
import com.example.mymanhwawithcompose.ui.theme.MyManhwaWithComposeTheme


@Preview(showBackground = true)
@Composable
fun ProfilePreview(){
    MyManhwaWithComposeTheme {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
){
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        CircleImage(image = R.drawable.me, contentDescription = "profile")

        Text(
            text = "Maisan Auliya",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            modifier = Modifier.padding(top = 32.dp)
        )
        Text(
            text = "maisanaulia02@gmail.com",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
    }

}


@Composable
fun CircleImage(
    @DrawableRes image: Int,
    contentDescription: String = "",
    modifier: Modifier = Modifier
){
    BoxWithConstraints {
        val imageSize = minOf(maxWidth, maxHeight)
        val imageModifier = modifier
            .size(imageSize)
            .clip(CircleShape)

        Image(
            painter = painterResource(id = image),
            contentDescription = contentDescription,
            modifier = imageModifier
        )
    }

}