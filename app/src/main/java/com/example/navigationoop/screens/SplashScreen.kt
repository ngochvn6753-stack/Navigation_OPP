package com.example.navigationoop.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.runtime.*
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun SplashScreen(
    onStart: () -> Unit
) {
    var progress by remember {
        mutableFloatStateOf(0f)
    }

    LaunchedEffect(Unit) {
        repeat(100) {
            delay(20)
            progress = (it + 1) / 100f
        }
        onStart()
    }
    Column(
        modifier = Modifier
            .background(Color(0xFF3155E7))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(
                    Color.White,
                    RoundedCornerShape(14.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Canvas(
                modifier = Modifier.size(36.dp)
            ) {
                val blue = Color(0xFF3155E7)

                for (i in 0..2) {
                    val y = size.height * (0.25f + i * 0.25f)

                    drawLine(
                        color = blue,
                        start = Offset(size.width * 0.12f, y),
                        end = Offset(size.width * 0.18f, y + 4.dp.toPx()),
                        strokeWidth = 2.dp.toPx(),
                        cap = StrokeCap.Round
                    )

                    drawLine(
                        color = blue,
                        start = Offset(size.width * 0.18f, y + 4.dp.toPx()),
                        end = Offset(size.width * 0.28f, y - 4.dp.toPx()),
                        strokeWidth = 2.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                    drawLine(
                        color = blue,
                        start = Offset(size.width * 0.40f, y),
                        end = Offset(size.width * 0.88f, y),
                        strokeWidth = 2.5.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "UTH Todo",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Việc học, việc nhà - gọn gàng mỗi ngày",
            color = Color.White,
            fontSize = 12.sp
        )
        Spacer(modifier = Modifier.height(40.dp))

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth(0.75f)
                .height(8.dp),
            color = Color.White,
            trackColor = Color.White.copy(alpha = 0.3f)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "${(progress * 100).toInt()}%",
            color = Color.White
        )
    }
}

