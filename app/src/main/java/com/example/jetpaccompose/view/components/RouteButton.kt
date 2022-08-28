package com.example.jetpaccompose.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpaccompose.R

data class RouteButtonModel(val routeId: String, val title: String, val icon: Int? = null)

@Composable
fun RouteButton(
    onClick: (String) -> Unit,
    model: RouteButtonModel
) {
    Row(modifier = Modifier
        .height(64.dp)
        .clickable { onClick.invoke(model.routeId) }
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconBox()
        Subtitle5(text = model.title,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .weight(1f))
        Image(
            painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24),
            contentDescription = "arrow right",
            modifier = Modifier
                .size(16.dp))
    }
}