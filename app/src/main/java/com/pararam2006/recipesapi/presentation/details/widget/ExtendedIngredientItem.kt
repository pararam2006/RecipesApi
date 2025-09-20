package com.pararam2006.recipesapi.presentation.details.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pararam2006.recipesapi.domain.dto.ExtendedIngredientDto
import com.pararam2006.recipesapi.presentation.theme.AppPadding

@Composable
fun ExtendedIngredientItem(
    ingredient: ExtendedIngredientDto
) {
    val url = "https://img.spoonacular.com/ingredients_100x100/${ingredient.image}"
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppPadding.default)
    ) {
        Image(
            painter = rememberAsyncImagePainter(url),
            contentDescription = ingredient.name,
            modifier = Modifier.size(50.dp),
            contentScale = ContentScale.FillBounds
        )
        Column {
            Text(ingredient.name)
            Text(ingredient.original)
        }
    }
}