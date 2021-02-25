package com.github.chiefchiefon.todolist.model

import androidx.room.*

@Dao
interface ToDoDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(toDoItem: ToDoItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateOrCreate(toDoItem: ToDoItem)

    @Delete
    fun delete(toDoItem: ToDoItem)

    @Query("SELECT * FROM todoitem WHERE isCompleted = 0")
    fun findUncompletedToDos(): List<ToDoItem>

    @Query("SELECT * FROM todoitem")
    fun getAllToDos(): List<ToDoItem>
}