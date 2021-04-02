package io.github.muth0mi.bibilia.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import io.github.muth0mi.bibilia.R
import io.github.muth0mi.bibilia.ui.bookList.Books
import io.github.muth0mi.bibilia.ui.bookList.BooksViewModel
import io.github.muth0mi.bibilia.ui.search.SearchScreen
import io.github.muth0mi.bibilia.ui.verses.Verses

@Composable
fun BibiliaApp(booksViewModel: BooksViewModel) {
    val navController = rememberNavController()

    val searchRoute = stringResource(R.string.route_search)
    val booksRoute = stringResource(R.string.route_books)
    val versesRoute = stringResource(R.string.route_verses)

    NavHost(navController, startDestination = booksRoute) {
        composable(searchRoute) { SearchScreen(navController) }
        composable(booksRoute) { Books(navController, booksViewModel) }
        composable(
            "$versesRoute/{bookId}",
            listOf(navArgument("bookId") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                Verses(navController, arguments.getInt("bookId"))
            }
        }
    }
}