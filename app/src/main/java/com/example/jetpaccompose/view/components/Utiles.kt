package com.example.jetpaccompose.view.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IconBox() {
    Box(modifier = Modifier
        .size(18.dp)
        .background(Color.LightGray))
}

@Composable
fun IconBox2() {
    Box(modifier = Modifier
        .size(18.dp)
        .background(Color.Black))
}