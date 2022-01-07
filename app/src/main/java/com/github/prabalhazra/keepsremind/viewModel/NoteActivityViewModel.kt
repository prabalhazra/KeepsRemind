package com.github.prabalhazra.keepsremind.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.prabalhazra.keepsremind.model.Note
import com.github.prabalhazra.keepsremind.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteActivityViewModel(private val repository: NoteRepository): ViewModel() {

    fun saveNote(addNote: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.addNote(addNote)
    }

    fun updateNote(updateNote: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.updateNote(updateNote)
    }

    fun deleteNote(deleteNote: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.deleteNote(deleteNote)
    }

    fun searchNote(query: String): LiveData<List<Note>> {
        return repository.searchNote(query)
    }

    fun getAllNote() : LiveData<List<Note>> = repository.getNote()
}