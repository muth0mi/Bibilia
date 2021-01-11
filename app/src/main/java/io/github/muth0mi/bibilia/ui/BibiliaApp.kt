package io.github.muth0mi.bibilia.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import io.github.muth0mi.bibilia.R
import io.github.muth0mi.bibilia.ui.books.Books
import io.github.muth0mi.bibilia.ui.verses.Verses

@Composable
fun BibiliaApp() {
    val navController = rememberNavController()

    val booksRoute = stringResource(R.string.route_books)
    val versesRoute = stringResource(R.string.route_verses)

    NavHost(navController, startDestination = booksRoute) {
        composable(booksRoute) { Books(navController) }
        composable(
            "$versesRoute/{bookId}",
            arguments = listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                Verses(navController, arguments.getInt("bookId"))
            }
        }
    }
}