package com.example.navigationoop.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.navigationoop.model.OnboardingPage
import com.example.navigationoop.model.IllustrationType
@Composable
fun OnboardingScreen(
    page: OnboardingPage,
    onNext: () -> Unit,
    onBack: () -> Unit,
    onSkip: () -> Unit,
    currentPage: Int,
    totalPages: Int,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TodoLogo()

            TextButton(onClick = onSkip) {
                Text("Bỏ qua")

            }
        }

            Spacer(modifier = Modifier.weight(1f))

            when (page.illustration) {
                IllustrationType.TASK -> TaskIllustration()
                IllustrationType.CATEGORY -> CategoryIllustration()
                IllustrationType.REMINDER -> ReminderIllustration()
            }
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = page.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xFF1E293B),
                lineHeight = 30.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = page.description,
                fontSize = 15.sp,
                textAlign = TextAlign.Center,
                color = Color.Gray,
                lineHeight = 23.sp
            )

            Spacer(modifier = Modifier.height(28.dp))

            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),
                shape = RoundedCornerShape(14.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF3658E4)
                )
            ) {
                Text(
                    text = if (currentPage == totalPages - 1)
                        "Bắt đầu"
                    else
                        "Tiếp tục",
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = onBack) {
                Text("Quay lại")
            }
        }
    }

