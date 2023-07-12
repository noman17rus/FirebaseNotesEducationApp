package com.example.firebaseeducationapp.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.firebaseeducationapp.MainViewModel
import com.example.firebaseeducationapp.MainViewModelFactory
import com.example.firebaseeducationapp.model.Note
import com.example.firebaseeducationapp.navigation.NavRoute

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(navController: NavHostController) {

    val context = LocalContext.current
    val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory())

    val notes = mViewModel.readTest.observeAsState(listOf()).value
    Scaffold(modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.size(70.dp), onClick = {
                navController.navigate(NavRoute.AddScreen.route)
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn() {
            items(notes) {
                NoteItem(note = it, navController = navController)
            }

        }

    }
}

@Composable
fun NoteItem(note: Note, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate(NavRoute.NoteScreen.route)
            }
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = note.tittle,
            fontSize = 32.sp,
            style = TextStyle.Default,
            fontWeight = FontWeight.Black
        )
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = note.subTittle
        )
    }
}
