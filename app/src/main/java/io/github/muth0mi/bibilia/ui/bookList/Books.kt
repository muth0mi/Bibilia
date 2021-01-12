package io.github.muth0mi.bibilia.ui.bookList

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsHeight
import io.github.muth0mi.bibilia.R
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.objects.Book

@Composable
fun Books(navController: NavController, booksViewModel: BooksViewModel) {
    val versesRoute = stringResource(R.string.route_verses)
    val openBook: (Book) -> Unit = {
        navController.navigate("$versesRoute/${it.id}")
    }

    BooksContent(
        testaments = booksViewModel.testaments,
        selectedTestament = booksViewModel.selectedTestament.value,
        onTestamentSelected = booksViewModel::onTestamentSelected,
        books = booksViewModel.books.value,
        openBook = openBook
    )
}

@Composable
fun BooksContent(
    testaments: List<Testament>,
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit,
    books: List<Book>,
    openBook: (Book) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = { BooksTopAppBar(testaments, selectedTestament, onTestamentSelected) },
        bodyContent = { BooksList(books, openBook) }
    )
}

@Composable
fun BooksTopAppBar(
    testaments: List<Testament>,
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit,
    modifier: Modifier = Modifier
) {
    val onClickToggle = {}

    val onClickSearch = {}

    Column(modifier = modifier.background(MaterialTheme.colors.primary)) {
        Spacer(
            modifier = Modifier
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
            .background(
                color,
                RoundedCornerShape(topLeftPercent = 100, topRightPercent = 100)
            )
    )
}

@Composable
fun BooksList(books: List<Book>, openBook: (Book) -> Unit) {
    LazyColumn(modifier = Modifier.navigationBarsPadding()) {
        items(items = books, itemContent = { book ->
            Card(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(
                        dimensionResource(R.dimen.default_padding),
                        dimensionResource(R.dimen.half_padding)
                    )
                    .clickable(onClick = { openBook.invoke(book) })
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