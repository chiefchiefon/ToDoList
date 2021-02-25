package com.github.chiefchiefon.todolist.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoItem::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}