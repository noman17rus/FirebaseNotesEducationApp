package com.example.firebaseeducationapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseeducationapp.model.Note
import com.example.firebaseeducationapp.utils.TYPE_FIREBASE
import com.example.firebaseeducationapp.utils.TYPE_ROOM

class MainViewModel() : ViewModel() {

    val readTest: MutableLiveData<List<Note>> = MutableLiveData<List<Note>>()

    val dbType: MutableLiveData<String> = MutableLiveData<String>(TYPE_ROOM)

    fun initDatabase(type: String) {
        dbType.value = type
        Log.d("CheckDB", "InitDataBase type: ${dbType.value}")
    }

    init {
        readTest.value = when (dbType.value) {
            TYPE_ROOM -> { listOf<Note>(
                Note(tittle = "Note1", subTittle = "sNote1"),
                Note(tittle = "Note2", subTittle = "sNote2"),
                Note(tittle = "Note3", subTittle = "sNote3"),
                Note(tittle = "Note4", subTittle = "sNote4")
            ) }
            TYPE_FIREBASE -> listOf()
            else -> listOf()
        }
    }
}


class MainViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }

}