package com.pararam2006.recipesapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.pararam2006.recipesapi.domain.dto.RecipeDto
import com.pararam2006.recipesapi.presentation.details.DetailsScreen
import com.pararam2006.recipesapi.presentation.main.MainScreen
import com.pararam2006.recipesapi.presentation.main.MainScreenViewModel
import com.pararam2006.recipesapi.presentation.navigation.Routes
import com.pararam2006.recipesapi.presentation.theme.RecipesApiTheme
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalSerializationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipesApiTheme {
                val startDestinationRoute = Routes.Main
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val startDestinationRouteString = serializer<Routes.Main>().descriptor.serialName
                val currentDestination = navBackStackEntry?.destination
                val currentRouteString = currentDestination?.route
                val canPop =
                    currentRouteString != null && currentRouteString != startDestinationRouteString

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = when {
                                        currentDestination?.hasRoute<Routes.Main>() == true -> {
                                            stringResource(R.string.main_screen_title)
                                        }

                                        currentDestination?.hasRoute<Routes.Details>() == true -> {
                                            stringResource(R.string.details_screen_title)
                                        }

                                        else -> {
                                            stringResource(R.string.unknown_screen_title)
                                        }
                                    },
                                    style = TextStyle(
                                        fontSize = 30.sp
                                    )
                                )
                            },
                            navigationIcon = {
                                if (canPop) {
                                    IconButton(onClick = { navController.popBackStack() }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = stringResource(R.string.nav_icon_content_desctiption)
                                        )
                                    }
                                }
                            }
                        )
                    },

                    ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = startDestinationRoute
                    ) {
                        composable<Routes.Main> {
                            val vm: MainScreenViewModel = koinViewModel()

                            MainScreen(
                                input = vm.input,
                                onInputChange = vm::changeInput,
                                recipes = vm.filteredRecipes,
                                categories = vm.categories.toList(),
                                modifier = Modifier.padding(innerPadding),
                                onCategorySelected = vm::selectCategory,
                                navController = navController,
                                onLoadMore = vm::getMoreRecipes,
                                isLoading = vm.isLoading,
                            )
                        }

                        composable<Routes.Details> { backStackEntry ->
                            val recipeDetails: Routes.Details = backStackEntry.toRoute()
                            val recipe = Json.decodeFromString<RecipeDto>(recipeDetails.recipeJson)
                            DetailsScreen(
                                recipe = recipe,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                    }
                }
            }
        }
    }
}
