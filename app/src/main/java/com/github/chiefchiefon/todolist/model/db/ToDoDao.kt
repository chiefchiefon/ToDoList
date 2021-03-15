package com.github.chiefchiefon.todolist.model.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(toDoItem: ToDoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateOrCreate(toDoItem: ToDoItem)

    @Delete
    suspend fun delete(toDoItem: ToDoItem)

    @Query("SELECT * FROM todoitem WHERE isCompleted = 1")
    fun findCompletedToDos(): LiveData<List<ToDoItem>>

    @Query("SELECT * FROM todoitem WHERE isCompleted = 0")
    fun findUncompletedToDos(): LiveData<List<ToDoItem>>

    @Query("SELECT * FROM todoitem")
    fun getAllToDos(): LiveData<List<ToDoItem>>
}