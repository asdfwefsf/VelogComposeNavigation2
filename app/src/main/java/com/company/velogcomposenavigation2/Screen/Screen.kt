package com.company.velogcomposenavigation2.Screen

// 3. 세번째 과정은 "Screen의 종류 정의하기"입니다.
// sealed class로서 Screen의 종류를 정의함으로서 개발 시 Screen의 종류의 맥스를 알 수 있어 개발에 편리하며
// Screen 들을 한 곳에 모아 관리 함으로서 개발에 용이합니다. 기존의 Legacy View에서 여러 Activity 또는 Fragment를
// 활용함으로서 화면을 구성했던 것 보다 @Composable function을 활용함으로서 화면을 쉽게 구성 할 수 있게 되었습니다.

sealed class Screen(val route : String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
}