package com.example.firebaseeducationapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebaseeducationapp.navigation.NavRoute
import com.example.firebaseeducationapp.navigation.NotesNavHost

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Start(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "What will we use?")
            Button(modifier = Modifier.width(200.dp),
                onClick = {
                    navController.navigate(NavRoute.MainScreen.route)
                }) {
                Text(text = "Room")
            }
            Button(modifier = Modifier.width(200.dp),
                onClick = {
                    navController.navigate(NavRoute.MainScreen.route)
                }) {
                Text(text = "FireBase")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun previewStart() {
    Start(navController = rememberNavController())
}