package com.example.firebaseeducationapp.database.room

import androidx.lifecycle.LiveData
import com.example.firebaseeducationapp.database.NoteRepository
import com.example.firebaseeducationapp.model.Note

class NoteRepositoryImpl(private val noteRoomDao: NoteRoomDao) : NoteRepository {

    override val readAllNotes: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun add(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
        onSuccess()
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note = note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note = note)
        onSuccess()
    }
}