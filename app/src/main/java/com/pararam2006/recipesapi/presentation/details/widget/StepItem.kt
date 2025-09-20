package com.pararam2006.recipesapi.presentation.details.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pararam2006.recipesapi.R
import com.pararam2006.recipesapi.domain.dto.EquipmentDto
import com.pararam2006.recipesapi.domain.dto.LengthDto
import com.pararam2006.recipesapi.domain.dto.StepDto
import com.pararam2006.recipesapi.domain.dto.StepIngredientDto
import com.pararam2006.recipesapi.presentation.theme.AppPadding
import com.pararam2006.recipesapi.presentation.theme.RecipesApiTheme

@Composable
fun StepItem(
    step: StepDto
) {
    val mediumPadding = AppPadding.medium
    Column(
        verticalArrangement = Arrangement.spacedBy(mediumPadding)
    ) {
        Text("Step ${step.number} : ${step.step}")

        Text(
            text = stringResource(R.string.ingredients_tab_title),
            style = MaterialTheme.typography.titleMedium
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(mediumPadding)
        ) {
            if (step.ingredients.isNotEmpty()) {
                items(step.ingredients) {
                    StepIngredientItem(it)
                }
            } else {
                item {
                    Text(
                        text = stringResource(R.string.no_step_ingrediets_msg)
                    )
                }
            }

        }

        Text(
            text = stringResource(R.string.equipment_tab_title),
            style = MaterialTheme.typography.titleMedium
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(mediumPadding),
        ) {
            if (step.equipment.isNotEmpty()) {
                items(step.equipment) {
                    EquipmentItem(it)
                }
            } else {
                item {
                    Text(
                        text = stringResource(R.string.no_equipment_msg)
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview
@Composable
private fun StepItemPreview() {
    RecipesApiTheme {
        StepItem(
            step = StepDto(
                number = 1,
                step = "Place the eggplant cubes in a strainer and sprinkle with the salt.",
                ingredients = listOf(
                    StepIngredientDto(
                        id = 11209,
                        name = "eggplant",
                        localizedName = "eggplant",
                        image = "eggplant.png"
                    ),
                    StepIngredientDto(
                        id = 2047,
                        name = "salt",
                        localizedName = "salt",
                        image = "salt.jpg"
                    )
                ),
                equipment = listOf(
                    EquipmentDto(
                        id = 405600,
                        name = "sieve",
                        localizedName = "sieve",
                        image = "https://spoonacular.com/cdn/equipment_100x100/strainer.png"
                    )
                ),
                length = LengthDto(
                    number = 0,
                    unit = ""
                )
            )
        )
    }
}