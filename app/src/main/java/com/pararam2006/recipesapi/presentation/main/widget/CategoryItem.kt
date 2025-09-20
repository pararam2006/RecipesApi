package com.pararam2006.recipesapi.presentation.main.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CategoryItem(
    icon: ImageVector = Icons.Default.Search,
    categoryName: String,
    onCategorySelected: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable {
            onCategorySelected(categoryName)
        }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Иконка",
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = categoryName
        )
    }
}