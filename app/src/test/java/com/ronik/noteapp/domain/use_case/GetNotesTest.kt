package com.ronik.noteapp.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ronik.noteapp.data.repository.FakeNoteRepository
import com.ronik.noteapp.domain.model.Note
import com.ronik.noteapp.domain.util.NoteOrder
import com.ronik.noteapp.domain.util.OrderType
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetNotesTest {

    private lateinit var  getNotes : GetNotes
    private lateinit var fakeNoteRepository: FakeNoteRepository


    @Before
    fun setUp(){
        fakeNoteRepository=FakeNoteRepository()
        getNotes=GetNotes(fakeNoteRepository)

        val notesToInsert = mutableListOf<Note>()
        ('a'..'z').forEachIndexed { index, c ->
            notesToInsert.add(
                Note(
                    title = c.toString(),
                    content = c.toString(),
                    timestamp = System.currentTimeMillis(),
                    color = index
                )
            )
        }
        notesToInsert.shuffle()
        runBlocking {
            notesToInsert.forEach { fakeNoteRepository.insertNote(it) }
        }

    }

    @Test
    fun `Order notes by title ascending, correct order`() = runBlocking {
        val notes = getNotes(NoteOrder.Title(OrderType.Ascending)).first()
        for(i in 0..notes.size - 2) {
            assertThat(notes[i].title).isLessThan(notes[i+1].title)
        }
    }


}