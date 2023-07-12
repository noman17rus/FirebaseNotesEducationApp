package com.example.firebaseeducationapp

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebaseeducationapp.database.room.AppRoomDataBase
import com.example.firebaseeducationapp.database.room.NoteRepositoryImpl
import com.example.firebaseeducationapp.model.Note
import com.example.firebaseeducationapp.utils.REPOSITORY
import com.example.firebaseeducationapp.utils.TYPE_FIREBASE
import com.example.firebaseeducationapp.utils.TYPE_ROOM

class MainViewModel(application: Application) : ViewModel() {


    val context = application
    fun initDatabase(type: String, onSuccess: () -> Unit) {
        Log.d("CheckDB", "InitDataBase type: ${type}")
        when (type) {
            TYPE_ROOM -> {
                val dao = AppRoomDataBase.getInstance(context = context).getRoomDao()
                REPOSITORY = NoteRepositoryImpl(dao)
                onSuccess()
            }


        }
    }

}


class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }

}