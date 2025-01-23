package com.ronik.noteapp.domain.use_case

import com.ronik.noteapp.domain.model.Note
import com.ronik.noteapp.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}