package com.example.homework2

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.homework2.ui.theme.Screen

@Composable
fun FirstScreen(navController: NavController, modifier: Modifier = Modifier){

    val list = List(7) { it }
    ImageList(list = list, navController)
}

@Composable
fun ImageList(list:List<Int>, navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {


        LazyColumn {
            items(list) {
                Button(
                    onClick = {
//                        navController.navigate(route = Screen.Second.route)
                        navController.navigate(route = "second_screen/" + it)

                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .height(120.dp)
                        .width(400.dp)
                        .padding(10.dp)

                ) {
                    val data = getButtonContent(id = it)
                    Text(
                        text = data[0] + "\n" + data[1],
                        textAlign = TextAlign.Center,
                        fontSize = 16.sp,
                        lineHeight = 30.sp
                    )
                }
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}
@Composable
fun getButtonContent(id: Int): List<String>{
    return when (id) {

        0 -> listOf(stringResource(R.string.taipei101_name), stringResource(R.string.taipei101_city))
        1 -> listOf(stringResource(R.string.museum_name), stringResource(R.string.museum_city))
        2 -> listOf(stringResource(R.string.memorial_hall_name), stringResource(R.string.memorial_hall_city))
        3 -> listOf(stringResource(R.string.Taroko_name), stringResource(R.string.Taroko_city))
        4 -> listOf(stringResource(R.string.sun_moon_lake_name), stringResource(R.string.sun_moon_lake_city))
        5 -> listOf(stringResource(R.string.yehliu_geopark_name), stringResource(R.string.yehliu_geopark_city))
        else -> listOf(stringResource(R.string.buddha_name), stringResource(R.string.buddha_city))
    }
}