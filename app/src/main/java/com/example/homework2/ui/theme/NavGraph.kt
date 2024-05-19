package com.example.homework2.ui.theme

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.homework2.FirstScreen
import com.example.homework2.SecondScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.First.route
    ){
        composable(
            route = Screen.First.route
        ) {
            FirstScreen(navController = navController)
        }

        composable(
            route = Screen.Second.route,
//            arguments = listOf(navArgument("id"){
//                type = NavType.IntType
//            })
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ) {
            Log.d("Args", it.arguments?.getInt("id").toString())
            val id = it.arguments?.getInt("id")
            SecondScreen(navController = navController, id = id?:0)
        }
    }
}