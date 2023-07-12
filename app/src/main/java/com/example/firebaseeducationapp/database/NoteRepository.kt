package com.example.firebaseeducationapp.database

import androidx.lifecycle.LiveData
import com.example.firebaseeducationapp.model.Note


interface NoteRepository {
    val readAllNotes: LiveData<List<Note>>
    suspend fun add(note: Note, onSuccess: ()-> Unit)
    suspend fun update(note: Note, onSuccess: ()-> Unit)
    suspend fun delete(note: Note, onSuccess: ()-> Unit)
}