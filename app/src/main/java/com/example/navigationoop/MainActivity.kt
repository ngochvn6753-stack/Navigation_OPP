package com.example.navigationoop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableIntStateOf
import com.example.navigationoop.model.IllustrationType
import com.example.navigationoop.ui.theme.NavigationOOPTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationoop.model.OnboardingPage
import com.example.navigationoop.screens.SplashScreen
import com.example.navigationoop.screens.OnboardingScreen
import com.example.navigationoop.screens.FinishScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationOOPTheme {

                val pages = listOf(
                    OnboardingPage(//tạo khuôn dữ liệu cho trang giới thiệu
                        title = "Mọi việc, gọn trong một nơi",
                        description = "Ghi lại bài tập, việc nhà, lịch hẹn. Không còn quên việc nào",
                        illustration = IllustrationType.TASK
                    ),
                    OnboardingPage(
                        title = "Chia theo Học tập và Cuộc sống",
                        description = "Mỗi việc có nhóm riếng, nhìn là biết hôm nay cần lo gì.",
                        illustration = IllustrationType.CATEGORY
                    ),
                    OnboardingPage(
                        title = "Nhắc đúng lúc",
                        description = "Bật thông báo để UTH Todo nhắc bạn trước hạn chót.",
                        illustration = IllustrationType.REMINDER
                    )

                )
                var currentPage by remember {
                    mutableIntStateOf(0)
                }

                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "splash"
                ) {
                    composable("splash") {
                        SplashScreen(
                            onStart = {
                                navController.navigate("onboarding") {
                                    popUpTo("splash") {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                }
                    composable("onboarding") {
                        OnboardingScreen(
                            page = pages[currentPage],
                            currentPage = currentPage,
                            totalPages = pages.size,

                            onNext = {
                                if (currentPage < pages.lastIndex) {
                                    currentPage++
                                } else {
                                    navController.navigate("finish")
                                }
                            },
                            onBack = {
                                if (currentPage > 0) {
                                    currentPage--
                                } else {
                                    navController.popBackStack()
                                }
                            },
                            onSkip = {
                                currentPage = pages.lastIndex
                            }
                        )
                    }
                    composable("finish") {
                        FinishScreen(
                            onRestart = {
                                currentPage = 0
                                navController.navigate("splash") {
                                    popUpTo("splash") {
                                        inclusive = true
                                    }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

