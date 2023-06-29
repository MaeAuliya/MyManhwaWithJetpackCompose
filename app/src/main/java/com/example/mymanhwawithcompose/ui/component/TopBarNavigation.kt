package com.example.mymanhwawithcompose.ui.component

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.mymanhwawithcompose.ui.theme.MyManhwaWithComposeTheme


@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    MyManhwaWithComposeTheme {
        TopBarNavigation(navController = rememberNavController(), text = "My Manhwa", showBackButton = true)
    }
}

@Composable
fun TopBarNavigation(
    navController: NavHostController,
    showBackButton: Boolean = false,
    text: String
){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        contentColor = contentColorFor(MaterialTheme.colorScheme.primary) )
    {
        Row(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
            if (showBackButton){
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            } else {
                Spacer(modifier = Modifier.width(48.dp))
            }
            
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            
            IconButton(onClick = { navController.navigate("profile") }) {
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
            }
            
        }
    }
}