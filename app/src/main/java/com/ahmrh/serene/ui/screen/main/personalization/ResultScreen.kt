package com.ahmrh.serene.ui.screen.main.personalization

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ahmrh.serene.R
import com.ahmrh.serene.common.CategoryUtils
import com.ahmrh.serene.ui.navigation.Screen
import com.ahmrh.serene.ui.theme.SereneTheme

@Composable
fun ResultScreen(

    navController: NavHostController = rememberNavController()
){


    Scaffold(
        topBar = {
            Row(
                Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.serene_icon_arrow_back),
                        contentDescription = null
                    )
                }

                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(id = R.drawable.serene_icon_share),
                        contentDescription = null
                    )
                }
            }
        }
    ) {
        Surface(
            modifier = Modifier.padding(it)
        ) {

            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .padding(top = 18.dp, bottom = 36.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painterResource(id = R.drawable.serene_selfcare_image_social),
                        contentDescription = null,
                        modifier = Modifier.size(180.dp)
                    )

                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){

                        Text("Social Self-care", style = MaterialTheme.typography.titleLarge)
                        Text("Based on your result",style = MaterialTheme.typography.bodyLarge)
                    }

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(24.dp)
                    ){
                        items(7){index ->
                            ResultBar(
                                "${CategoryUtils.getCategory(index + 1).stringValue}",
                                50,
                                100
                            )
                        }
                    }

                }

                Button(
                    onClick = {
                              navController.navigate(
                                  Screen.Home.route){

                                  popUpTo(navController.graph.findStartDestination().id) {
                                      saveState = true
                                  }
                              }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Go to Activities")


                }
            }

        }

    }
}

@Composable
fun ResultBar(
    title: String,
    point: Int,
    maxPoint: Int,
){
    val percentage = (point / maxPoint.toFloat())
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal=8.dp)
    ){
        Text(title, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, modifier = Modifier.width(100.dp))

        LinearProgressIndicator(
            progress = percentage ,
            modifier = Modifier
                .weight(1f)
        )
        Text("${(percentage * 100).toInt()}%", style = MaterialTheme.typography.labelMedium)

    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview(){
    SereneTheme {
        ResultScreen()
    }
}