package io.github.muth0mi.bibilia.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import io.github.muth0mi.bibilia.R


@Composable
fun BooksTopAppBar(title: String) {
    val onClickToggle = {
    }

    val onClickSearch = {
    }

    Column() {
        TopAppBar(
            navigationIcon = {
                IconButton(onClick = onClickToggle) {
                    Icon(Icons.Filled.Menu)
                }
            },
            title = { Text(text = title) },
            actions = {
                IconButton(onClick = onClickSearch) {
                    Icon(Icons.Filled.Search)
                }
            }
        )

        var selectedTabIndex = 0
        TabRow(selectedTabIndex = selectedTabIndex) {
            Tab(selected = selectedTabIndex == 0, onClick = { selectedTabIndex = 0 }) {
                Text(text = stringResource(R.string.old_testament))
            }
            Tab(selected = selectedTabIndex == 1, onClick = { selectedTabIndex = 1 }) {
                Text(text = stringResource(R.string.new_testament))
            }
        }
    }
}
