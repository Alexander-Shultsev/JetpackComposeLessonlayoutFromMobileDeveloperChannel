package com.example.jetpaccompose.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.jetpaccompose.brawnGrayColor
import com.example.jetpaccompose.whiteTwo

data class CharacteristicsModel(
    val title: String,
    val value: String
)

@Composable
fun CharacterListItem(model: CharacteristicsModel) {
    Column {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .height(60.dp),
            verticalAlignment = Alignment.CenterVertically)
        {
            Text(model.title, modifier = Modifier.weight(.6f), style = TextStyle(color = brawnGrayColor))
            Subtitle5(model.value, modifier = Modifier.weight(.4f))
        }
        Divider(color = whiteTwo, thickness = 2.dp)
    }
}
