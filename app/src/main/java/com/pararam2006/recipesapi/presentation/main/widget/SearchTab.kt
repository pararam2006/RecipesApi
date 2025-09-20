package com.pararam2006.recipesapi.presentation.main.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pararam2006.recipesapi.R
import com.pararam2006.recipesapi.presentation.theme.AppPadding
import com.pararam2006.recipesapi.presentation.theme.RecipesApiTheme

@Composable
fun SearchTab(
    input: String,
    onInputChange: (String) -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(AppPadding.default)
    ) {
        Text(
            text = stringResource(R.string.search_tab_title)
        )

        OutlinedTextField(
            value = input,
            onValueChange = onInputChange,
            shape = RoundedCornerShape(35),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Поиск",
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            )
        )
    }
}

@Preview
@Composable
private fun SearchTabPreview() {
    RecipesApiTheme {
        SearchTab(
            input = "",
            onInputChange = {}
        )
    }
}