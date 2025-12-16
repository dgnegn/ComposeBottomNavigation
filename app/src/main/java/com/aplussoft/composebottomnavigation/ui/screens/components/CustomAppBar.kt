@file:OptIn(ExperimentalMaterial3Api::class)

package com.aplussoft.composebottomnavigation.ui.screens.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable

@Composable
fun CustomAppBar(
    title: String,
    onNavigateBack: @Composable (() -> Unit)?,
    actions: @Composable (() -> Unit)? = {},
) {
    TopAppBar(
        colors = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            scrolledContainerColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            subtitleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        title = { Text(text = title) },
        navigationIcon = { onNavigateBack?.invoke() },
        actions = { actions?.invoke() }

    )
}

