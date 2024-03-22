package com.company.velogcomposenavigation2.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
// 6-2. : Data를 전달 받는 Screen에서 설정 해줘야 하는 것들.
// 다른 composable에서 넘겨주는 Data를 받기 위해서는 화면을 구성하는 ComposableFunction의 Parameter에
// 받아줄 Data에 관한 사전 정보를 넣어줘야 합니다.
fun DetailScreen(navController: NavController , name1 : String? , name2 : String? , name3 : String?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp),
        verticalArrangement = Arrangement.Center
        ) {
        Button(
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            }
        ) {
            Text(text = "Go To MainScreen")
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Hello, $name1")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Hello, $name2")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "${name3}")
    }
}