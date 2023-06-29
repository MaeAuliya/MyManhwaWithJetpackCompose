package com.example.mymanhwawithcompose.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mymanhwawithcompose.R
import com.example.mymanhwawithcompose.ui.theme.MyManhwaWithComposeTheme
import com.example.mymanhwawithcompose.ui.theme.Shapes

@Composable
fun ManhwaItem(
    image: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier
){
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .clip(shape = Shapes.medium)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1.0f)
        ){
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            Text(
                text = description,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.Normal
                ),
                maxLines = 5
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ManhwaItemPreview(){
    MyManhwaWithComposeTheme {
        ManhwaItem(image = R.drawable.sololeveling, title = "Solo Leveling", description = stringResource(
            id = R.string.title_1_desc
        ))
    }
}