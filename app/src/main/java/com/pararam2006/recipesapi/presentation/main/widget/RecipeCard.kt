package com.pararam2006.recipesapi.presentation.main.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.presentation.theme.AppPadding
import com.pararam2006.recipesapi.presentation.theme.cardBackgroundPrimary

@Composable
fun RecipeCard(
    recipe: RecipeDto,
    onClick: () -> Unit,
    clickEnabled: Boolean = true
) {
    Box(
        modifier = Modifier
            .width(400.dp)
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(35)
            }
            .background(cardBackgroundPrimary),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(AppPadding.medium),
            modifier = Modifier
                .padding(AppPadding.medium)
                .clickable(enabled = clickEnabled) { onClick() }
        ) {
            Image(
                painter = rememberAsyncImagePainter("https://img.spoonacular.com/recipes/${recipe.id}-556x370.jpg"),
                contentDescription = "",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .height(270.dp)
            )

            RecipeCardTextBlock(
                title = recipe.title,
                diets = recipe.diets.ifEmpty { listOf("no diets") },
                servings = recipe.servings,
                minutes = recipe.readyMinutes,
                likes = recipe.aggregateLikes
            )
        }
    }
}
