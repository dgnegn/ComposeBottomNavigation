package com.aplussoft.composebottomnavigation.ui.screens.notes

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.aplussoft.composebottomnavigation.ui.screens.components.CustomAppBar


@ExperimentalMaterial3Api
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Notes(
    onNavigateToNoteDetails: (Int) -> Unit,
) {
    Scaffold(topBar = {
        CustomAppBar(
            title = "Notes",
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
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Go to Note Details")
                Button(onClick = {
                    onNavigateToNoteDetails(1)
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "back"
                    )
                }
            }
        }
    }

}