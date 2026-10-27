package com.example.navigationoop.model

enum class IllustrationType {
    TASK,
    CATEGORY,
    REMINDER
}

data class OnboardingPage(
    val title: String,
    val description: String,
    val illustration: IllustrationType
)