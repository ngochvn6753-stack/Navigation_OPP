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
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin

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
        val logoBlue = Color(0xFF3355FF)

        Box(
            modifier = Modifier
                .size(88.dp)
                .background(logoBlue, RoundedCornerShape(19.dp)),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(58.dp)) {
                val w = size.width
                val stroke = w * 0.082f

                val y1 = size.height * 0.34f
                val y2 = size.height * 0.68f

                val cx = w * 0.20f
                val r = w * 0.16f

                drawCircle(
                    color = Color.White,
                    radius = r,
                    center = Offset(cx, y1)
                )

                val tick = Path().apply {
                    moveTo(cx - r * 0.45f, y1)
                    lineTo(cx - r * 0.1f, y1 + r * 0.4f)
                    lineTo(cx + r * 0.5f, y1 - r * 0.35f)
                }
                drawPath(
                    path = tick,
                    color = logoBlue,
                    style = Stroke(
                        width = w * 0.055f,
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )

                drawLine(
                    color = Color.White,
                    start = Offset(w * 0.50f, y1),
                    end = Offset(w * 0.92f, y1),
                    strokeWidth = stroke,
                    cap = StrokeCap.Round
                )

                drawCircle(
                    color = Color.White,
                    radius = w * 0.109f,
                    center = Offset(cx, y2),
                    style = Stroke(width = stroke)
                )
                drawLine(
                    color = Color.White,
                    start = Offset(w * 0.50f, y2),
                    end = Offset(w * 0.92f, y2),
                    strokeWidth = stroke,
                    cap = StrokeCap.Round
                )
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

