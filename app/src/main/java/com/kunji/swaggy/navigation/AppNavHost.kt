package com.kunji.swaggy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kunji.swaggy.ui.screens.category.CategoryScreen
import com.kunji.swaggy.ui.screens.contacts.ContactsScreen
import com.kunji.swaggy.ui.screens.dashboard.DashboardScreen
import com.kunji.swaggy.ui.screens.detail.DetailScreen
import com.kunji.swaggy.ui.screens.home.AboutScreen
import com.kunji.swaggy.ui.screens.home.HomeScreen
import com.kunji.swaggy.ui.screens.intent.IntentScreen
import com.kunji.swaggy.ui.screens.item.ItemScreen
import com.kunji.swaggy.ui.screens.scaffold.ScaffoldScreen
import com.kunji.swaggy.ui.screens.splash.SplashScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_CONTACT) {
            ContactsScreen(navController)
        }

        composable(ROUT_ITEM) {
            ItemScreen(navController)
        }

        composable(ROUT_CATEGORY) {
            CategoryScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_SCAFFOLD) {
            ScaffoldScreen(navController)
        }

        composable(ROUT_DETAIL) {
            DetailScreen(navController)
        }

        composable(ROUT_INTENT) {
            IntentScreen(navController)
        }

        composable(ROUT_DASHBOARD) {
            DashboardScreen(navController)
        }




    }
}