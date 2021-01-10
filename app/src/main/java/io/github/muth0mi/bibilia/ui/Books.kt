package io.github.muth0mi.bibilia.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import io.github.muth0mi.bibilia.R

@Composable
fun BooksList(books: List<String>, onClickBook: (String) -> Unit) {
    LazyColumn {
        items(items = books, itemContent = { book ->
            Card(
                modifier = Modifier
                    .clickable(onClick = { onClickBook.invoke(book) })
                    .fillParentMaxWidth()
                    .padding(
                        dimensionResource(R.dimen.default_padding),
                        dimensionResource(R.dimen.half_padding)
                    )
            ) {
                Text(
                    text = book,
                    modifier = Modifier.padding(dimensionResource(R.dimen.default_padding)),
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface
                )
            }
        })
    }
}