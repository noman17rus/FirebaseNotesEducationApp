package com.example.firebaseeducationapp.screens

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebaseeducationapp.navigation.NavRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Add(navController: NavHostController) {
    var tittle by remember { mutableStateOf("") }
    var subTittle by remember { mutableStateOf("") }
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Add new Note")
            OutlinedTextField(
                modifier = Modifier.padding(8.dp),
                value = tittle,
                onValueChange = { tittle = it },
                label = { Text(text = "Tittle") })
            OutlinedTextField(
                modifier = Modifier.padding(8.dp),
                value = subTittle,
                onValueChange = { subTittle = it },
                label = { Text(text = "Subtittle") })
            Button(onClick = {
                navController.navigate(NavRoute.MainScreen.route)
            }) {
                Text(text = "Save new note")
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun previewAdd() {
    Add(navController = rememberNavController())
}