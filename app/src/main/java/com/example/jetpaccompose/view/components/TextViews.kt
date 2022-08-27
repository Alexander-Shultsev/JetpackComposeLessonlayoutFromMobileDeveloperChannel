package com.example.jetpaccompose.view.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.jetpaccompose.brawnGrayColor


@Composable
fun Subtitle4(text: String, modifier: Modifier = Modifier) =
    Text(text,
        modifier = modifier,
        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Medium, fontSize = 14.sp))

@Composable
fun Subtitle5(text: String, modifier: Modifier = Modifier) =
    Text(text,
        modifier = modifier,
        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Normal, fontSize = 14.sp))

@Composable
fun Subtitle6(text: String, modifier: Modifier = Modifier) =
    Text(text,
        modifier = modifier,
        style = TextStyle(color = brawnGrayColor, fontWeight = FontWeight.Medium, fontSize = 14.sp))
