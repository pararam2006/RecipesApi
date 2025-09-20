package com.pararam2006.recipesapi.presentation.main.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pararam2006.recipesapi.R
import com.pararam2006.recipesapi.presentation.theme.AppPadding
import com.pararam2006.recipesapi.presentation.theme.RecipesApiTheme

@Composable
fun Categories(
    categories: List<String>,
    onCategorySelected: (String) -> Unit,
) {
    Column {
        Text(
            text = stringResource(R.string.categories_tab_title)
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(AppPadding.default),
        ) {
            items(categories) { dishType ->
                CategoryItem(
                    categoryName = dishType,
                    onCategorySelected = { onCategorySelected(dishType) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun CategoriesPreview() {
    RecipesApiTheme {
        Categories(
            categories = listOf(
                "Завтрак",
                "Обед",
                "Полдник",
                "Ужин",
            ),
            onCategorySelected = {},
        )
    }
}