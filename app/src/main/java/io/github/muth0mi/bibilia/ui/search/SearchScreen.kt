package io.github.muth0mi.bibilia.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import io.github.muth0mi.bibilia.R

@Composable
fun SearchScreen(navController: NavController) {
    val goBack: () -> Unit = { navController.navigateUp() }

    Scaffold(
        topBar = {
            SearchBar(
                searchQuery = "",
                onSearchQueryChanged = { },
                dismissSearchBox = { })
        },
        bodyContent = { SearchResults() }
    )
}

@Composable
private fun SearchBar(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    dismissSearchBox: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(dimensionResource(id = R.dimen.default_padding))) {
        TextField(
            value = searchQuery,
            onValueChange = { onSearchQueryChanged.invoke(it) },
//            modifier = Modifier.fillMaxWidth()
        )
        Icon(
            Icons.Filled.Close,
            modifier = Modifier.clickable(onClick = dismissSearchBox)
        )
    }
}

@Composable
fun SearchResults(modifier: Modifier = Modifier) {
    Text(text = stringResource(R.string.empty_recent_search))
}