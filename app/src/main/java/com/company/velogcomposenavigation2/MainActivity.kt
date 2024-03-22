package com.company.velogcomposenavigation2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.company.velogcomposenavigation2.`2-SharedViewModel`.SharedViewModelSample
import com.company.velogcomposenavigation2.Screen.DetailScreen
import com.company.velogcomposenavigation2.Screen.MainScreen
import com.company.velogcomposenavigation2.Screen.Screen
import com.company.velogcomposenavigation2.ui.theme.VelogComposeNavigation2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VelogComposeNavigation2Theme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Navigation()
                    SharedViewModelSample()
                }
            }
        }
    }
}
