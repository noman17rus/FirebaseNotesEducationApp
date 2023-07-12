package com.example.firebaseeducationapp.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firebaseeducationapp.model.Note

@Database(entities = [Note::class], version = 1)
abstract class AppRoomDataBase : RoomDatabase() {


    abstract fun getRoomDao(): NoteRoomDao

    companion object {

        private var INSTANCE: AppRoomDataBase? = null

        fun getInstance(context: Context): AppRoomDataBase {
            return if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context = context,
                    AppRoomDataBase::class.java,
                    "noteDataBase"
                ).build()
                INSTANCE as AppRoomDataBase
            } else INSTANCE as AppRoomDataBase
        }
    }

}