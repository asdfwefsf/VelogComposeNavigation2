package com.company.velogcomposenavigation2.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var text1 by remember {
        mutableStateOf("")
    }
    var text2 by remember {
        mutableStateOf("")
    }
    val text3 by remember {
        mutableStateOf(3)
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text1,
            onValueChange = {
                text1 = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = text2,
            onValueChange = {
                text2 = it
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                // 6-1.2 :
                // navController.navigate() pareameter에 들어가는 route에 넘겨줄 데이터를 문자열 표현으로 작성해준다.
                // 이때 //를 사용해서 경로를 표현하게 되는데 / 와 / 사이에 빈값이 들어가면 navController가 경로를 찾지 못해서 에러가 발생하므로
                // 다음과 같은 두가지 방법 중 하나의 방법을 선택해서 /와 / 사이의 값이 붕떠버리는 경우를 방지해야한다.

                // 6-1.3 : 넘겨줄 Data가 빈 값일 경우 navController.navigate() 사용법 1
                // 전달할 Data가 빈 값일 경우 임의의 빈값을 직접 넣어준다
//                if(text1 == "") {
//                    text1 = "default1"
//                }
//                if(text2 == "") {
//                    text2 = "default2"
//                }
//                navController.navigate(Screen.DetailScreen.route + "/${text1}/${text2}/${text3}")

                // 6-1.4 : 넘겨줄 Data가 빈 값일 경우 navController.navigate() 사용법 2
                // 전달할 Data가 빈 값이 아닐 경우에만 navController가 navigate()를 사용할 수 있게 조건을 걸어준다.
                // 이때에 전달할 Data가 여러 개일 경우에는 빈 값이 될 수 있는 것들을 묶어서 && 활용한 조건문으로 모든 Data가 빈값이 되지 않도록 컨트롤 해줘야 한다.
                if(text1.isNotEmpty() && text2.isNotEmpty() && !text2.isNullOrEmpty()) {
                    navController.navigate(Screen.DetailScreen.route + "/${text1}/${text2}/$text3")
                }
                // 5. navController를 이용해서 화면 이동하기
                // navController.navigate("경로 이름") : 이렇게 하면 현제 화면에서 "경로 이름"을 "route"로 갖는 composable로 이동합니다.
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To DetailScreen")
        }
    }
}