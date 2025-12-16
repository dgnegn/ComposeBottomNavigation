package com.aplussoft.composebottomnavigation.ui.screens.categories

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aplussoft.composebottomnavigation.ui.screens.components.CustomAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Categories() {
    Scaffold(topBar = {
        CustomAppBar(
            title = "Categories",
            onNavigateBack = null,
            actions = null
        )
    }) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Categories")

            }
        }
    }

}