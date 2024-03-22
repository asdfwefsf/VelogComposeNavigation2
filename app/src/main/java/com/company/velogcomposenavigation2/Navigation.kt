package com.company.velogcomposenavigation2

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.company.velogcomposenavigation2.Screen.DetailScreen
import com.company.velogcomposenavigation2.Screen.MainScreen
import com.company.velogcomposenavigation2.Screen.Screen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val navController1 = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        // composable Tip
        // composable(route = "목적지 이름") {
        //     해당 목적지 화면(navController)
        // }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
        composable(
            // 6-3. composable의 route Parameter에 경로 설정을 추가로 진행해준다.
            // 이때 navController는 route가 문자열이여만 인식 할 수 있기 때문에 , 문자열로서 경로를 지정해준다.
            route = Screen.DetailScreen.route + "/{my name1}/{my name2}/{my name3}",
            // arguments 는 listOf()에 navArgument("해당 스크린을 정의한 Composable Function의 Parameter 이름")를
            // 사용해서 각각의 Parameter에 대한 여러 설정을 NavArgumentBuilder를 통해서 진행하게 됩니다.
            arguments = listOf(
                navArgument("my name1") {
                    type = NavType.StringType
                    defaultValue = "GeonHee1"
                    nullable = true
                },
                navArgument("my name2") {
                    type = NavType.StringType
                    defaultValue = "GeonHee2"
                    nullable = true
                },
                navArgument("my name3") {
                    type = NavType.StringType
                    defaultValue = "0"
                    nullable = true
                }
            )
        ) {
            DetailScreen(
                navController = navController,
                name1 = it.arguments?.getString("my name1"),
                name2 = it.arguments?.getString("my name2"),
                name3 = it.arguments?.getString("my name3")
            )
        }
    }
}










