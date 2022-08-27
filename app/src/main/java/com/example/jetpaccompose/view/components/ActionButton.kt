package com.example.jetpaccompose.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import com.example.jetpaccompose.ViewModel.MainViewModel

data class ActionButtonModel (
    val title: String,
    val selectedTitle: String,
    val icon: String? = null,
    val isSelected: Boolean = false
)

@Composable
fun ActionButton(
    model: ActionButtonModel,
    onClick: (ActionButtonModel, Boolean) -> Unit,
) {
    var isSelected by remember { mutableStateOf(model.isSelected) }

    Box(modifier = Modifier
        .height(80.dp)
        .padding(16.dp)
        .background(Color.White)
    ) {
        Card(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    isSelected = !isSelected
                    onClick.invoke(model, !isSelected)
                },
            backgroundColor = if (isSelected) Color.White else Color.LightGray,
            shape = RoundedCornerShape(4.dp),
            border = if (isSelected) BorderStroke(2.dp, Color.Black) else null,
            elevation = 0.dp
        ) {
            Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically) {
                Subtitle4(
                    if (isSelected) model.selectedTitle else model.title,
                    modifier = Modifier
                        .weight(1f))

                if (isSelected) {
                    IconBox2()
                } else {
                    IconBox()
                }
            }
        }
    }
}