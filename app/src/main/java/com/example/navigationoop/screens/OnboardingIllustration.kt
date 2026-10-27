package com.example.navigationoop.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke

@Composable
fun TaskIllustration(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFFF2F5FF),
                RoundedCornerShape(20.dp)
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Việc hôm nay",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3658E4)
        )

        TaskItem("Làm bài tập", true)
        TaskItem("Dọn phòng", true)
        TaskItem("Đọc sách", false)
    }
}

@Composable
private fun TaskItem(
    name: String,
    completed: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(12.dp)
            )
            .padding(14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (completed) "✓" else "⊗",
            color = if (completed)
                Color(0xFF3658E4)
            else
                Color.Gray,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = name,
            fontSize = 16.sp,
            color = Color.DarkGray
        )
    }
}
    @Composable
    fun CategoryIllustration() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color(0xFFF0F4FF),
                    RoundedCornerShape(20.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Text(
                text = "Danh mục công việc",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3658E4)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CategoryCard(
                    title = "📚 Học tập",
                    count = "5 công việc",
                    color = Color(0xFFE5EDFF),
                    modifier = Modifier.weight(1f)
                )

                CategoryCard(
                    title = "🏠 Cuộc sống",
                    count = "3 công việc",
                    color = Color(0xFFFFE8DD),
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }


    @Composable
    private fun CategoryCard(
        title: String,
        count: String,
        color: Color,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
                .background(Color.White, RoundedCornerShape(14.dp))
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(color, RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(title.take(2), fontSize = 24.sp)
            }

            Text(
                title.drop(2).trim(),
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Text(
                count,
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }

@Composable
fun ReminderIllustration() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color(0xFFF0F4FF),
                RoundedCornerShape(20.dp)
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Text(
            text = "🔔 Lời nhắc của bạn",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3658E4)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(14.dp)
                )
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "🔔 Nộp bài tập",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Đừng quên hạn chót nhé!",
                fontSize = 13.sp,
                color = Color.Gray
            )

            HorizontalDivider()

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "🕗 08:00 sáng",
                    fontSize = 13.sp
                )

                Text(
                    text = "Đã bật",
                    color = Color(0xFF3658E4),
                    fontSize = 13.sp
                )
            }
        }
    }
}
@Composable
fun TodoLogo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(
                    Color(0xFF3355FF),
                    RoundedCornerShape(10.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(22.dp)) {
                val white = Color.White
                val stroke = 1.8.dp.toPx()

                val y1 = size.height * 0.34f
                val y2 = size.height * 0.68f

                // Hàng trên: vòng tròn nhỏ + đường kẻ
                // Hàng trên: hình tròn đặc trắng + dấu tích xanh + đường kẻ
                val cx = size.width * 0.20f
                val r = 3.2.dp.toPx()

                drawCircle(
                    color = white,
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
                    color = Color(0xFF3355FF), // trùng màu nền ô vuông
                    style = Stroke(
                        width = 1.2.dp.toPx(),
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round
                    )
                )

                drawLine(
                    color = white,
                    start = Offset(size.width * 0.50f, y1),
                    end = Offset(size.width * 0.92f, y1),
                    strokeWidth = stroke,
                    cap = StrokeCap.Round
                )


            // Hàng dưới: gạch ngắn + đường kẻ
                drawCircle(
                    color = white,
                    radius = 2.4.dp.toPx(),
                    center = Offset(size.width * 0.20f, y2),
                    style = Stroke(width = stroke)
                )
                drawLine(
                    color = white,
                    start = Offset(size.width * 0.50f, y2),
                    end = Offset(size.width * 0.92f, y2),
                    strokeWidth = stroke,
                    cap = StrokeCap.Round
                )
            }
        }
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("UTH ")
                    }
                    withStyle(
                        SpanStyle(
                            color = Color(0xFF3155E7),
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Todo")
                    }
                },
                fontSize = 20.sp
            )
        }
    }

