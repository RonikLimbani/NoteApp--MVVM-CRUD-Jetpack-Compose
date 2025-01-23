package com.ronik.noteapp.presentation.notes

import com.ronik.noteapp.domain.model.Note
import com.ronik.noteapp.domain.util.NoteOrder
import com.ronik.noteapp.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)