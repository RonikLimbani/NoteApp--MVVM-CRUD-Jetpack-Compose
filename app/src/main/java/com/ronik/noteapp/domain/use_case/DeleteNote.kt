package com.ronik.noteapp.domain.use_case

import com.ronik.noteapp.domain.model.Note
import com.ronik.noteapp.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}