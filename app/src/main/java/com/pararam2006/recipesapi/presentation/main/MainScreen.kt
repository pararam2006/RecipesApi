package com.pararam2006.recipesapi.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.pararam2006.recipesapi.domain.dto.AnalyzedInstructionDto
import com.pararam2006.recipesapi.domain.dto.EquipmentDto
import com.pararam2006.recipesapi.domain.dto.ExtendedIngredientDto
import com.pararam2006.recipesapi.domain.dto.LengthDto
import com.pararam2006.recipesapi.domain.dto.MeasureDto
import com.pararam2006.recipesapi.domain.dto.MeasuresDto
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.domain.dto.StepDto
import com.pararam2006.recipesapi.domain.dto.StepIngredientDto
import com.pararam2006.recipesapi.domain.dto.WinePairingDto
import com.pararam2006.recipesapi.presentation.main.widget.Categories
import com.pararam2006.recipesapi.presentation.main.widget.Recipes
import com.pararam2006.recipesapi.presentation.main.widget.SearchTab
import com.pararam2006.recipesapi.presentation.theme.AppPadding
import com.pararam2006.recipesapi.presentation.theme.RecipesApiTheme

@Composable
fun MainScreen(
    input: String,
    recipes: List<RecipeDto>,
    categories: List<String>,
    onInputChange: (String) -> Unit,
    onCategorySelected: (String) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val mediumPadding = AppPadding.medium
    Column(
        verticalArrangement = Arrangement.spacedBy(AppPadding.large),
        modifier = modifier
            .fillMaxSize()
            .padding(
                start = mediumPadding,
                end = mediumPadding
            )
    ) {
        SearchTab(
            input = input,
            onInputChange = onInputChange
        )

        Categories(
            categories = categories,
            onCategorySelected = onCategorySelected,
        )

        Recipes(
            recipes = recipes,
            navController = navController
        )
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    RecipesApiTheme {
        MainScreen(
            input = "Макароны с сыром",
            onInputChange = {},
            categories = listOf(
                "Завтрак",
                "Обед",
                "Полдник",
                "Ужин",
            ),
            onCategorySelected = {},
            navController = rememberNavController(),
            recipes = listOf(
                RecipeDto(
                    id = 716218,
                    title = "Tomato and Eggplant Caponata",
                    image = "https://img.spoonacular.com/recipes/716218-556x370.jpg",
                    imageType = "jpg",
                    servings = 10,
                    readyMinutes = 45,
                    cookingMinutes = 0,
                    preparationMinutes = 0,
                    license = "",
                    sourceName = "foodandspice.com",
                    sourceUrl = "https://www.foodandspice.com/2012/08/caponata-eggplant-and-tomato-salad.html",
                    spoonacularSourceUrl = "https://spoonacular.com/tomato-and-eggplant-caponata-716218",
                    healthScore = 7,

                    analyzedInstructions = listOf(
                        AnalyzedInstructionDto(
                            name = "",
                            steps = listOf<StepDto>(
                                StepDto(
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
                                ),
                                StepDto(
                                    number = 2,
                                    step = "Let stand for 1 hour. Rinse and pat dry with a clean tea towel. Set aside.",
                                    ingredients = listOf(
                                        StepIngredientDto(
                                            id = 14355,
                                            name = "tea",
                                            localizedName = "tea",
                                            image = "tea-bags.jpg"
                                        )
                                    ),
                                    equipment = listOf(
                                        EquipmentDto(
                                            id = 221439,
                                            name = "kitchen towels",
                                            localizedName = "kitchen towels",
                                            image = "https://spoonacular.com/cdn/equipment_100x100/dish-towel.jpg"
                                        )
                                    ),
                                    length = LengthDto(
                                        number = 60,
                                        unit = "minutes"
                                    )
                                ),
                                StepDto(
                                    number = 3,
                                    step = "Heat 1 tablespoon of the olive oil in a medium heavy-bottomed saucepan over medium heat. When hot, add the onion, celery and garlic and saut for 5 to 10 minutes or until the vegetables are tender.Now add the tomatoes, jalapeos, cumin, curry powder and cayenne and simmer for another few minutes, stirring often. Next add the vinegar, capers, olives and brown sugar if using to the pan  Continue to simmer for another 5 to 10 minutes.",
                                    ingredients = listOf(
                                        StepIngredientDto(
                                            id = 2015,
                                            name = "curry powder",
                                            localizedName = "curry powder",
                                            image = "curry-powder.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 19334,
                                            name = "brown sugar",
                                            localizedName = "brown sugar",
                                            image = "dark-brown-sugar.png"
                                        ),
                                        StepIngredientDto(
                                            id = 11583,
                                            name = "vegetable",
                                            localizedName = "vegetable",
                                            image = "https://spoonacular.com/cdn/ingredients_100x100/mixed-vegetables.png"
                                        ),
                                        StepIngredientDto(
                                            id = 4053,
                                            name = "olive oil",
                                            localizedName = "olive oil",
                                            image = "olive-oil.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 11529,
                                            name = "tomato",
                                            localizedName = "tomato",
                                            image = "tomato.png"
                                        ),
                                        StepIngredientDto(
                                            id = 2031,
                                            name = "ground cayenne pepper",
                                            localizedName = "ground cayenne pepper",
                                            image = "chili-powder.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 2053,
                                            name = "vinegar",
                                            localizedName = "vinegar",
                                            image = "vinegar-(white).jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 2054,
                                            name = "capers",
                                            localizedName = "capers",
                                            image = "capers.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 11143,
                                            name = "celery",
                                            localizedName = "celery",
                                            image = "celery.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 11215,
                                            name = "garlic",
                                            localizedName = "garlic",
                                            image = "garlic.png"
                                        ),
                                        StepIngredientDto(
                                            id = 9195,
                                            name = "olives",
                                            localizedName = "olives",
                                            image = "olives-mixed.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 1002014,
                                            name = "cumin",
                                            localizedName = "cumin",
                                            image = "ground-cumin.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 11282,
                                            name = "onion",
                                            localizedName = "onion",
                                            image = "brown-onion.png"
                                        )
                                    ),
                                    equipment = listOf(
                                        EquipmentDto(
                                            id = 404669,
                                            name = "sauce pan",
                                            localizedName = "sauce pan",
                                            image = "https://spoonacular.com/cdn/equipment_100x100/sauce-pan.jpg"
                                        ),
                                        EquipmentDto(
                                            id = 404645,
                                            name = "frying pan",
                                            localizedName = "frying pan",
                                            image = "https://spoonacular.com/cdn/equipment_100x100/pan.png"
                                        )
                                    ),
                                    length = LengthDto(
                                        number = 10,
                                        unit = "minutes"
                                    )
                                ),
                                StepDto(
                                    number = 4,
                                    step = "Heat the remaining tablespoon of olive oil in a frying pan over medium heat. When hot, toss in the eggplant cubes and stir for 5 minutes or until lightly browned.",
                                    ingredients = listOf(
                                        StepIngredientDto(
                                            id = 4053,
                                            name = "olive oil",
                                            localizedName = "olive oil",
                                            image = "olive-oil.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 11209,
                                            name = "eggplant",
                                            localizedName = "eggplant",
                                            image = "eggplant.png"
                                        )
                                    ),
                                    equipment = listOf(
                                        EquipmentDto(
                                            id = 404645,
                                            name = "frying pan",
                                            localizedName = "frying pan",
                                            image = "https://spoonacular.com/cdn/equipment_100x100/pan.png"
                                        )
                                    ),
                                    length = LengthDto(
                                        number = 5,
                                        unit = "minutes"
                                    )
                                ),
                                StepDto(
                                    number = 5,
                                    step = "Add the eggplant to the tomato mixture. Continue to simmer for another 10 minutes and taste for seasoning.",
                                    ingredients = listOf(
                                        StepIngredientDto(
                                            id = 1042027,
                                            name = "seasoning",
                                            localizedName = "seasoning",
                                            image = "seasoning.png"
                                        ),
                                        StepIngredientDto(
                                            id = 11209,
                                            name = "eggplant",
                                            localizedName = "eggplant",
                                            image = "eggplant.png"
                                        ),
                                        StepIngredientDto(
                                            id = 11529,
                                            name = "tomato",
                                            localizedName = "tomato",
                                            image = "tomato.png"
                                        )
                                    ),
                                    equipment = emptyList(),
                                    length = LengthDto(
                                        number = 10,
                                        unit = "minutes"
                                    )
                                ),
                                StepDto(
                                    number = 6,
                                    step = "Remove from heat and let cool to room temperature.",
                                    ingredients = emptyList(),
                                    equipment = emptyList(),
                                    length = LengthDto(
                                        number = 0,
                                        unit = ""
                                    )
                                ),
                                StepDto(
                                    number = 7,
                                    step = "Garnish with parsley and serve with flatbreads or toasted pitas.",
                                    ingredients = listOf(
                                        StepIngredientDto(
                                            id = 11297,
                                            name = "parsley",
                                            localizedName = "parsley",
                                            image = "parsley.jpg"
                                        ),
                                        StepIngredientDto(
                                            id = 18413,
                                            name = "pita",
                                            localizedName = "pita",
                                            image = "pita-bread.jpg"
                                        )
                                    ),
                                    equipment = emptyList(),
                                    length = LengthDto(
                                        number = 0,
                                        unit = ""
                                    )
                                )
                            ),
                            spoonacularScore = 59.4925346374512,
                            spoonacularSourceUrl = "https://spoonacular.com/tomato-and-eggplant-caponata-716218"
                        )
                    ),
                    cheap = false,
                    creditsText = "foodandspice.com",
                    cuisines = emptyList(),
                    diets = listOf("gluten free", "dairy free", "lacto ovo vegetarian", "vegan"),
                    gaps = "no",
                    glutenFree = true,
                    instructions = "Place the eggplant cubes in a strainer and sprinkle with the salt. Let stand for 1 hour. Rinse and pat dry with a clean tea towel. Set aside. Heat 1 tablespoon of the olive oil in a medium heavy-bottomed saucepan over medium heat. When hot, add the onion, celery and garlic and saut for 5 to 10 minutes or until the vegetables are tender.Now add the tomatoes, jalapeos, cumin, curry powder and cayenne and simmer for another few minutes, stirring often. Next add the vinegar, capers, olives and brown sugar if using to the pan  Continue to simmer for another 5 to 10 minutes. Heat the remaining tablespoon of olive oil in a frying pan over medium heat. When hot, toss in the eggplant cubes and stir for 5 minutes or until lightly browned. Add the eggplant to the tomato mixture. Continue to simmer for another 10 minutes and taste for seasoning. Remove from heat and let cool to room temperature.Garnish with parsley and serve with flatbreads or toasted pitas.",
                    ketogenic = false,
                    lowFodmap = false,
                    occasions = emptyList(),
                    sustainable = false,
                    vegan = true,
                    vegetarian = true,
                    veryHealthy = false,
                    veryPopular = false,
                    whole30 = false,
                    weightWatcherSmartPoints = 1,
                    dishTypes = listOf("side dish"),
                    extendedIngredients = listOf(
                        ExtendedIngredientDto(
                            id = 2069,
                            aisle = "Oil, Vinegar, Salad Dressing",
                            image = "balsamic-vinegar.jpg",
                            consistency = "LIQUID",
                            name = "balsamic vinegar",
                            nameClean = "balsamic vinegar",
                            original = "2 tablespoons balsamic vinegar",
                            originalName = "balsamic vinegar",
                            amount = 2.0,
                            unit = "tablespoons",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "Tbsps",
                                    unitLong = "Tbsps"
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "Tbsps",
                                    unitLong = "Tbsps"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 19334,
                            aisle = "Baking",
                            image = "light-brown-sugar.jpg",
                            consistency = "SOLID",
                            name = "brown sugar",
                            nameClean = "brown sugar",
                            original = "1 tablespoon brown sugar (optional)",
                            originalName = "brown sugar (optional)",
                            amount = 1.0,
                            unit = "tablespoon",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "Tbsp",
                                    unitLong = "Tbsp"
                                ),
                                metric = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "Tbsp",
                                    unitLong = "Tbsp"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 2054,
                            aisle = "Canned and Jarred",
                            image = "capers.jpg",
                            consistency = "SOLID",
                            name = "capers",
                            nameClean = "capers",
                            original = "2 tablespoons capers",
                            originalName = "capers",
                            amount = 2.0,
                            unit = "tablespoons",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "Tbsps",
                                    unitLong = "Tbsps"
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "Tbsps",
                                    unitLong = "Tbsps"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 2031,
                            aisle = "Spices and Seasonings",
                            image = "chili-powder.jpg",
                            consistency = "SOLID",
                            name = "cayenne",
                            nameClean = "cayenne",
                            original = "1/2 teaspoon cayenne",
                            originalName = "cayenne",
                            amount = 0.5,
                            unit = "teaspoon",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 0.5,
                                    unitShort = "tsps",
                                    unitLong = "teaspoons"
                                ),
                                metric = MeasureDto(
                                    amount = 0.5,
                                    unitShort = "tsps",
                                    unitLong = "teaspoons"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 11143,
                            aisle = "Produce",
                            image = "celery.jpg",
                            consistency = "SOLID",
                            name = "celery",
                            nameClean = "celery",
                            original = "2 stalks celery, finely sliced",
                            originalName = "celery, finely sliced",
                            amount = 2.0,
                            unit = "stalks",
                            meta = listOf("finely sliced"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "stalks",
                                    unitLong = "stalks"
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "stalks",
                                    unitLong = "stalks"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 2015,
                            aisle = "Spices and Seasonings",
                            image = "curry-powder.jpg",
                            consistency = "SOLID",
                            name = "curry powder",
                            nameClean = "curry powder",
                            original = "1 teaspoon curry powder (optional)",
                            originalName = "curry powder (optional)",
                            amount = 1.0,
                            unit = "teaspoon",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "tsp",
                                    unitLong = "teaspoon"
                                ),
                                metric = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "tsp",
                                    unitLong = "teaspoon"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 11209,
                            aisle = "Produce",
                            image = "eggplant.png",
                            consistency = "SOLID",
                            name = "eggplants",
                            nameClean = "eggplants",
                            original = "2 medium eggplants, peeled and cut into small cubes",
                            originalName = "eggplants, peeled and cut into small cubes",
                            amount = 2.0,
                            unit = "medium",
                            meta = listOf("peeled", "cut into small cubes"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "medium",
                                    unitLong = "mediums"
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "medium",
                                    unitLong = "mediums"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 10511297,
                            aisle = "Produce",
                            image = "parsley.jpg",
                            consistency = "SOLID",
                            name = "parsley",
                            nameClean = "parsley",
                            original = "large handful fresh parsley, chopped",
                            originalName = "fresh parsley, chopped",
                            amount = 1.0,
                            unit = "large handful",
                            meta = listOf("fresh", "chopped"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "large handful",
                                    unitLong = "large handful"
                                ),
                                metric = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "large handful",
                                    unitLong = "large handful"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 11215,
                            aisle = "Produce",
                            image = "garlic.png",
                            consistency = "SOLID",
                            name = "garlic",
                            nameClean = "garlic",
                            original = "1 clove garlic, minced",
                            originalName = "garlic, minced",
                            amount = 1.0,
                            unit = "clove",
                            meta = listOf("minced"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "clove",
                                    unitLong = "clove"
                                ),
                                metric = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "clove",
                                    unitLong = "clove"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 1012014,
                            aisle = "Spices and Seasonings",
                            image = "ground-cumin.jpg",
                            consistency = "SOLID",
                            name = "ground cumin",
                            nameClean = "ground cumin",
                            original = "1 teaspoon ground cumin",
                            originalName = "ground cumin",
                            amount = 1.0,
                            unit = "teaspoon",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "tsp",
                                    unitLong = "teaspoon"
                                ),
                                metric = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "tsp",
                                    unitLong = "teaspoon"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 1002030,
                            aisle = "Spices and Seasonings",
                            image = "pepper.jpg",
                            consistency = "SOLID",
                            name = "ground pepper",
                            nameClean = "ground pepper",
                            original = "fresh ground black pepper to taste",
                            originalName = "fresh ground black pepper to taste",
                            amount = 10.0,
                            unit = "servings",
                            meta = listOf("fresh", "black", "to taste"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 10.0,
                                    unitShort = "servings",
                                    unitLong = "servings"
                                ),
                                metric = MeasureDto(
                                    amount = 10.0,
                                    unitShort = "servings",
                                    unitLong = "servings"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 11979,
                            aisle = "Canned and Jarred",
                            image = "jalapeno-pepper.png",
                            consistency = "SOLID",
                            name = "jalapeños",
                            nameClean = "jalapeños",
                            original = "2 jalapeños, seeded and finely chopped",
                            originalName = "jalapeños, seeded and finely chopped",
                            amount = 2.0,
                            unit = "",
                            meta = listOf("seeded", "finely chopped"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "",
                                    unitLong = ""
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "",
                                    unitLong = ""
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 1009195,
                            aisle = "Canned and Jarred",
                            image = "calamata-or-kalamata-olives.jpg",
                            consistency = "SOLID",
                            name = "kalamata olives",
                            nameClean = "kalamata olives",
                            original = "2/3 cup Kalamata olives, pitted and chopped",
                            originalName = "Kalamata olives, pitted and chopped",
                            amount = 0.6666667,
                            unit = "cup",
                            meta = listOf("pitted", "chopped"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 0.6666667,
                                    unitShort = "cups",
                                    unitLong = "cups"
                                ),
                                metric = MeasureDto(
                                    amount = 90.0,
                                    unitShort = "ml",
                                    unitLong = "milliliters"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 4053,
                            aisle = "Oil, Vinegar, Salad Dressing",
                            image = "olive-oil.jpg",
                            consistency = "LIQUID",
                            name = "olive oil",
                            nameClean = "olive oil",
                            original = "2 tablespoons olive oil",
                            originalName = "olive oil",
                            amount = 2.0,
                            unit = "tablespoons",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "Tbsps",
                                    unitLong = "Tbsps"
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "Tbsps",
                                    unitLong = "Tbsps"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 11282,
                            aisle = "Produce",
                            image = "brown-onion.png",
                            consistency = "SOLID",
                            name = "onion",
                            nameClean = "onion",
                            original = "1 small onion, finely chopped",
                            originalName = "onion, finely chopped",
                            amount = 1.0,
                            unit = "small",
                            meta = listOf("finely chopped"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "small",
                                    unitLong = "small"
                                ),
                                metric = MeasureDto(
                                    amount = 1.0,
                                    unitShort = "small",
                                    unitLong = "small"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 1012047,
                            aisle = "Spices and Seasonings",
                            image = "salt.jpg",
                            consistency = "SOLID",
                            name = "sea salt",
                            nameClean = "sea salt",
                            original = "1/2 teaspoon sea salt, or to taste",
                            originalName = "sea salt, or to taste",
                            amount = 0.5,
                            unit = "teaspoon",
                            meta = listOf("to taste"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 0.5,
                                    unitShort = "tsps",
                                    unitLong = "teaspoons"
                                ),
                                metric = MeasureDto(
                                    amount = 0.5,
                                    unitShort = "tsps",
                                    unitLong = "teaspoons"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 1012047,
                            aisle = "Spices and Seasonings",
                            image = "salt.jpg",
                            consistency = "SOLID",
                            name = "sea salt",
                            nameClean = "sea salt",
                            original = "2 teaspoons sea salt",
                            originalName = "sea salt",
                            amount = 2.0,
                            unit = "teaspoons",
                            meta = emptyList(),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "tsps",
                                    unitLong = "teaspoons"
                                ),
                                metric = MeasureDto(
                                    amount = 2.0,
                                    unitShort = "tsps",
                                    unitLong = "teaspoons"
                                )
                            )
                        ),
                        ExtendedIngredientDto(
                            id = 11529,
                            aisle = "Produce",
                            image = "tomato.png",
                            consistency = "SOLID",
                            name = "tomatoes",
                            nameClean = "tomatoes",
                            original = "3 large tomatoes, seeded and finely chopped",
                            originalName = "tomatoes, seeded and finely chopped",
                            amount = 3.0,
                            unit = "large",
                            meta = listOf("seeded", "finely chopped"),
                            measures = MeasuresDto(
                                us = MeasureDto(
                                    amount = 3.0,
                                    unitShort = "large",
                                    unitLong = "larges"
                                ),
                                metric = MeasureDto(
                                    amount = 3.0,
                                    unitShort = "large",
                                    unitLong = "larges"
                                )
                            )
                        )
                    ),
                    summary = "Tomato and Eggplant Caponatan is a gluten free, dairy free, lacto ovo vegetarian, and vegan side dish. One serving contains 86 calories, 2g of protein, and 5g of fat. This recipe serves 10 and costs 82 cents per serving. If you have ground cumin, eggplants, capers, and a few other ingredients on hand, you can make it. It is brought to you by foodandspice.blogspot.com. 53 people were glad they tried this recipe. From preparation to the plate, this recipe takes about 45 minutes. Taking all factors into account, this recipe earns a spoonacular score of 56%, which is solid. If you like this recipe, take a look at these similar recipes: Eggplant Caponata, Eggplant Caponata, and Eggplant Caponata.",
                    winePairing = WinePairingDto(
                        pairedWines = emptyList(),
                        pairedText = "",
                        productMatches = emptyList()
                    ),
                    spoonacularScore = 59.4925346374512,
                    pricePerServing = 81.69,
                    aggregateLikes = 53
                )
            )
        )
    }
}