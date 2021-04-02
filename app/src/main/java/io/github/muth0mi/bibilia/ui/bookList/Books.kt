package io.github.muth0mi.bibilia.ui.bookList

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.TabDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import io.github.muth0mi.bibilia.R
import io.github.muth0mi.bibilia.data.emuns.Testament
import io.github.muth0mi.bibilia.data.emuns.Testament.New
import io.github.muth0mi.bibilia.data.objects.Book
import kotlin.random.Random

@Composable
fun Books(navController: NavController, booksViewModel: BooksViewModel) {
    val versesRoute = stringResource(R.string.route_verses)
    val openBook: (Book) -> Unit = {
        navController.navigate("$versesRoute/${it.id}")
    }

    val searchRoute = stringResource(R.string.route_search)
    val openSearchScreen: () -> Unit = {
        navController.navigate(searchRoute)
    }

    Scaffold(
        bodyContent = {
            BooksContent(
                selectedTestament = booksViewModel.selectedTestament.value,
                onTestamentSelected = booksViewModel::onTestamentSelected,
                books = booksViewModel.books.value,
                openBook = openBook
            )
        },
        bottomBar = { BooksBottomAppBar() },
        floatingActionButton = { SearchFAB(onClick = openSearchScreen) },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        modifier = Modifier.statusBarsPadding()
    )
}

@Composable
fun BooksContent(
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit,
    books: List<Book>,
    openBook: (Book) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .navigationBarsPadding()
            .padding(bottom = 56.dp)
    ) {
        item {
            Column {
                RecentBooks(
                    books = books,
                    modifier = Modifier
                        .padding(0.dp, dimensionResource(id = R.dimen.default_padding))
                )
                Text(
                    text = stringResource(R.string.books),
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier
                        .padding(
                            start = dimensionResource(id = R.dimen.default_padding),
                            end = dimensionResource(id = R.dimen.default_padding),
                            top = dimensionResource(id = R.dimen.default_padding)
                        )
                )
                TestamentTabs(
                    // testaments = books.map { it.testament }.distinct(),
                    testaments = listOf(New, Testament.Old),
                    selectedTestament = selectedTestament,
                    onTestamentSelected = onTestamentSelected,
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.default_padding))
                )
            }
        }
        items(items = books, itemContent = { book ->
            Card(
                modifier = Modifier
                    .fillParentMaxWidth()
                    .padding(
                        dimensionResource(R.dimen.default_padding),
                        dimensionResource(R.dimen.half_padding)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .clickable(onClick = { openBook.invoke(book) })
                        .padding(dimensionResource(R.dimen.default_padding))
                ) {
                    Text(
                        text = book.name,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        })
    }
}

@Composable
fun RecentBooks(books: List<Book>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.pick_up_reading),
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.default_padding))
        )
        ScrollableRow {
            books.forEach {
                Column(Modifier.padding(horizontal = dimensionResource(R.dimen.half_padding))) {
                    Card(
                        modifier = Modifier
                            .height(240.dp)
                            .preferredWidth(120.dp)
                    ) {
                        Image(
                            bitmap = imageResource(id = R.drawable.ic_menu_gallery),
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(MaterialTheme.colors.primary.copy(alpha = Random.nextFloat()))
                        )
                    }
                    Text(
                        text = it.name,
                        style = MaterialTheme.typography.subtitle2,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Composable
private fun TestamentTabs(
    testaments: List<Testament>,
    selectedTestament: Testament,
    onTestamentSelected: (Testament) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
        val selectedIndex = testaments.indexOfFirst { it == selectedTestament }
        val indicator = @Composable { tabPositions: List<TabPosition> ->
            TestamentTabIndicator(Modifier.tabIndicatorOffset(tabPositions[selectedIndex]))
        }
        TabRow(
            selectedTabIndex = selectedIndex,
            indicator = indicator,
            divider = {},
            backgroundColor = MaterialTheme.colors.primary.copy(alpha = .05F)
        ) {
            val oldTestament = stringResource(R.string.old_testament)
            val newTestament = stringResource(R.string.new_testament)
            testaments.forEachIndexed { index, testament ->
                val selected = index == selectedIndex
                val text = if (testament == New) oldTestament else newTestament
                var style = MaterialTheme.typography.body2
                if (selected) style = style.merge(TextStyle(fontWeight = Bold))
                Tab(
                    selected = selected,
                    onClick = { onTestamentSelected(testament) },
                    text = { Text(text = text, style = style) }
                )
            }
        }
    }
}

@Composable
fun TestamentTabIndicator(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .fillMaxHeight()
            .background(MaterialTheme.colors.primary.copy(alpha = .2F))
    )
}

@Composable
fun BooksBottomAppBar(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        BottomAppBar(cutoutShape = MaterialTheme.shapes.small) {
            IconButton(onClick = {}) { Icon(Icons.Filled.Menu) }
            IconButton(onClick = {}) { Icon(Icons.Filled.Menu) }
            IconButton(onClick = {}) { Icon(Icons.Filled.Menu) }
        }
        Spacer(
            modifier = Modifier
                .background(MaterialTheme.colors.primary)
                .navigationBarsHeight()
                .fillMaxWidth()
        )
    }
}

@Composable
fun SearchFAB(onClick: () -> Unit, modifier: Modifier = Modifier) {
    FloatingActionButton(onClick = { onClick.invoke() }, modifier = modifier) {
        Icon(Icons.Filled.Search)
    }
}