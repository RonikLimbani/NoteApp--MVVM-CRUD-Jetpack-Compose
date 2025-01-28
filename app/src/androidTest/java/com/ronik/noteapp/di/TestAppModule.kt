package com.ronik.noteapp.di



import android.app.Application
import androidx.room.Room
import com.ronik.noteapp.data.data_source.NoteDatabase
import com.ronik.noteapp.data.repository.NoteRepositoryImpl
import com.ronik.noteapp.domain.repository.NoteRepository
import com.ronik.noteapp.domain.use_case.AddNote
import com.ronik.noteapp.domain.use_case.DeleteNote
import com.ronik.noteapp.domain.use_case.GetNote
import com.ronik.noteapp.domain.use_case.GetNotes
import com.ronik.noteapp.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java,
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}