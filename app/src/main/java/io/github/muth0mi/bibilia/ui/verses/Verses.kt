package io.github.muth0mi.bibilia.ui.verses

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.NavController
import dev.chrisbanes.accompanist.insets.statusBarsHeight
import io.github.muth0mi.bibilia.R

@Composable
fun Verses(navController: NavController, bookId: Int) {
    val viewModel: VersesViewModel = viewModel()
    val viewState by viewModel.state.collectAsState()

    val goBack: () -> Unit = { navController.navigateUp() }

    VersesContent(
        goBack = goBack,
        bookId = bookId
    )
}

@Composable
fun VersesContent(goBack: () -> Unit, bookId: Int) {
    Column {
        VersesTopAppBar()
        Text(
            text = "Verses $bookId", modifier = Modifier.clickable(onClick = { goBack.invoke() })
        )
    }
}

@Composable
fun VersesTopAppBar(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Spacer(Modifier.background(MaterialTheme.colors.primary).fillMaxWidth().statusBarsHeight())

        TopAppBar(
            navigationIcon = { IconButton(onClick = {}) { Icon(Icons.Filled.Menu) } },
            title = { Text(text = stringResource(R.string.books)) },
            actions = { IconButton(onClick = { }) { Icon(Icons.Filled.Search) } },
            elevation = 0.dp
        )
    }
}