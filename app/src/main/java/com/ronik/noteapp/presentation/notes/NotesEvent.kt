package com.ronik.noteapp.presentation.notes

import com.ronik.noteapp.domain.model.Note
import com.ronik.noteapp.domain.util.NoteOrder


sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    data object RestoreNote: NotesEvent()
    data object ToggleOrderSection: NotesEvent()
}