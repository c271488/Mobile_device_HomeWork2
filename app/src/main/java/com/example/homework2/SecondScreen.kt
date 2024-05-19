package com.example.homework2

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController


@Composable
fun SecondScreen(navController: NavController, id :Int = 0, modifier: Modifier = Modifier){
    ArtSpace(navController, id)
}

@Composable
fun ArtSpace(navController: NavController, id :Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .fillMaxHeight(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .align(Alignment.Start)
        ){
            Icon(
                Icons.Filled.ArrowBack,
                "back",
            )
        }
        val (attraction, attractionName, attractionAddress, attractionDescription) = getPageContent(id)//paramater
        val attractionUrl = stringResource(id = getUrl(id))
        PageContent(attraction = attraction, attractionName = attractionName, attractionAddress = attractionAddress, attractionDescription = attractionDescription)

        Spacer(Modifier.height(40.dp))


        val context = LocalContext.current
        Button(
            onClick = {
                val mapUri = Uri.parse( attractionUrl )
                val intent = Intent(Intent. ACTION_VIEW, mapUri)
                startActivity(context, intent, null)
            }
        ) {
            Text(
                text = "View in Google Map",
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun PageContent(attraction: Int, attractionName: Int, attractionAddress: Int, attractionDescription: Int, modifier: Modifier = Modifier){
    Box(
        modifier = modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Column(

        ){

            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.white)),
                shape = RectangleShape,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),

                ){
                Image(
                    painter = painterResource(attraction) ,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier
                        .width(450.dp)
                        .padding(10.dp)
                        .align(Alignment.CenterHorizontally)

                )
            }

            BoxWithConstraints {
                Spacer(Modifier.height(40.dp))
            }
            Text(

                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(color = Color.Black, fontSize = 22.sp, fontWeight = FontWeight.Bold, baselineShift = BaselineShift(1.5f)),

                        ) {
                        append(stringResource(id = attractionName)+"\n")
                    }
//                    withStyle(
//                        style = SpanStyle(fontSize = 1.sp),
//                    ) {
//                        append("\n")
//                    }
                    withStyle(
                        style = SpanStyle(color = Color.Blue, baselineShift = BaselineShift(1f)),
                    ) {
                        append(stringResource(id = attractionDescription)+"\n")
                    }

                    withStyle(
                        style = SpanStyle(color = Color.Black),
                    ) {
                        append(stringResource(id = attractionAddress))
                    }
                },
                modifier = modifier
                    //.height(130.dp)
                    .width(320.dp)
                    .background(color = Color.LightGray)
                    .padding(10.dp)
                    .align(Alignment.CenterHorizontally),
                lineHeight = 24.sp
            )
        }

    }
}



private fun getPageContent(id: Int): List<Int> {
    return when (id) {
        // 11 images
        0 -> listOf(R.drawable.taipei101, R.string.taipei101_name, R.string.taipei101_address, R.string.taipei101_description)
        1 -> listOf(R.drawable.museum, R.string.museum_name, R.string.museum_address, R.string.museum_description)
        2 -> listOf(R.drawable.memorial_hall, R.string.memorial_hall_name, R.string.memorial_hall_address, R.string.memorial_hall_description)
        3 -> listOf(R.drawable.taroko, R.string.Taroko_name, R.string.Taroko_address, R.string.Taroko_description)
        4 -> listOf(R.drawable.sun_moon_lake, R.string.sun_moon_lake_name, R.string.sun_moon_lake_address, R.string.sun_moon_lake_description)
        5 -> listOf(R.drawable.yehliu_geopark, R.string.yehliu_geopark_name, R.string.yehliu_geopark_address, R.string.yehliu_geopark_description)
        else -> listOf(R.drawable.buddha, R.string.buddha_name, R.string.buddha_address, R.string.buddha_description)
    }
}

@Composable
private fun getUrl(id: Int): Int {
    return when (id) {

        0 -> R.string.taipei101_url

        1 -> R.string.museum_url
        2 -> R.string.memorial_hall_url
        3 -> R.string.Taroko_url
        4 -> R.string.sun_moon_lake_url
        5 -> R.string.yehliu_geopark_url
        else -> R.string.buddha_url
    }
}