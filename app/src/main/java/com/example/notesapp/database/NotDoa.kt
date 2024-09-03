package com.example.notesapp.database
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert
    suspend fun upsertNote(n:Note) // without id -> insert and with existing id -> update

    @Delete
    suspend fun deleteNote(n:Note)

    @Query("SELECT * FROM note")
    fun getAllNotes(): Flow<List<Note>>

}