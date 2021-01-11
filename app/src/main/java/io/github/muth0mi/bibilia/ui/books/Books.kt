package io.github.muth0mi.bibilia.ui.books

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.insets.statusBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import io.github.muth0mi.bibilia.R
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book

@Composable
fun Books(navController: NavController) {
    val booksViewModel: BooksViewModel = viewModel()
    val viewState by booksViewModel.state.collectAsState()

    val versesRoute = stringResource(R.string.route_verses)
    val onBookClicked: (Book) -> Unit = { navController.navigate("$versesRoute/${it.id}") }

    BooksContent(
        testaments = viewState.testaments,
        selectedTestament = viewState.selectedTestament,
        onTestamentSelected = booksViewModel::onTestamentSelected,
        books = viewState.books,
        onBookClicked = onBookClicked
    )
}

@Composable
fun BooksContent(
    testaments: List<Testament>,
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit,
    books: List<Book>,
    onBookClicked: (Book) -> Unit
) {
    Column {
        BooksTopAppBar(testaments, selectedTestament, onTestamentSelected)
        BooksList(books, onBookClicked)
    }
}

@Composable
fun BooksTopAppBar(
    testaments: List<Testament>,
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit,
    modifier: Modifier = Modifier
) {
    val onClickToggle = {
    }

    val onClickSearch = {
    }

    Column(modifier = modifier) {
        Spacer(
            Modifier
                .background(MaterialTheme.colors.primary)
                .fillMaxWidth()
                .statusBarsHeight()
        )

        TopAppBar(
            navigationIcon = { IconButton(onClick = onClickToggle) { Icon(Icons.Filled.Menu) } },
            title = { Text(text = stringResource(R.string.books)) },
            actions = { IconButton(onClick = onClickSearch) { Icon(Icons.Filled.Search) } },
            elevation = 0.dp
        )

        TestamentTabs(testaments, selectedTestament, onTestamentSelected)
    }
}

@Composable
private fun TestamentTabs(
    testaments: List<Testament>,
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit
) {
    val selectedIndex = testaments.indexOfFirst { it == selectedTestament }
    val indicator = @Composable { tabPositions: List<TabPosition> ->
        TestamentTabIndicator(Modifier.tabIndicatorOffset(tabPositions[selectedIndex]))
    }

    TabRow(selectedTabIndex = selectedIndex, indicator = indicator) {
        val oldTestament = stringResource(R.string.old_testament)
        val newTestament = stringResource(R.string.new_testament)
        testaments.forEachIndexed { index, testament ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onTestamentSelected(testament) },
                text = {
                    Text(
                        text = if (testament == Testament.New) oldTestament else newTestament,
                        style = MaterialTheme.typography.body2
                    )
                }
            )
        }
    }
}

@Composable
fun TestamentTabIndicator(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onPrimary
) {
    Spacer(
        modifier = modifier
            .padding(horizontal = dimensionResource(R.dimen.default_padding))
            .preferredHeight(4.dp)
            .background(color, RoundedCornerShape(topLeftPercent = 100, topRightPercent = 100))
    )
}

@Composable
fun BooksList(books: List<Book>, onBookClicked: (Book) -> Unit) {
    LazyColumn(modifier = Modifier.navigationBarsPadding()) {
        items(items = books, itemContent = { book ->
            Card(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(
                        dimensionResource(R.dimen.default_padding),
                        dimensionResource(R.dimen.half_padding)
                    )
                    .clickable(onClick = { onBookClicked.invoke(book) })
            ) {
                Text(
                    text = book.name,
                    modifier = Modifier.padding(dimensionResource(R.dimen.default_padding)),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }
        })
    }
}