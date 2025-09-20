package com.pararam2006.recipesapi.presentation.main.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pararam2006.recipesapi.presentation.theme.AppPadding

@Composable
fun RecipeCardTextBlock(
    title: String,
    diets: List<String>,
    servings: Int,
    minutes: Int,
    likes: Int,
) {
    Column(
        modifier = Modifier.padding(AppPadding.medium)
    ) {
        Text(
            text = title,
            style = TextStyle(fontSize = 20.sp)
        )

        Text(
            text = "$diets"
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "$servings servings ")

        Text(text = "$minutes minutes")

        Text(text = "$likes likes")
    }
}