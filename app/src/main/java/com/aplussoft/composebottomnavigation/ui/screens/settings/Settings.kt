package com.aplussoft.composebottomnavigation.ui.screens.settings


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aplussoft.composebottomnavigation.ui.screens.components.CustomAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings() {
    Scaffold(topBar = {
        CustomAppBar(
            title = "Settings",
            onNavigateBack = null,
            actions = null
        )
    }) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                Text(text = "Settings")

            }
        }
    }

}