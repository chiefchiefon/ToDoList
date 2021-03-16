package com.github.chiefchiefon.todolist.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoItem (
    /**
     * We'll always use id, because it accelerate the access to DB
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val itemText: String,
    val isCompleted: Boolean = false,
    val priority: Int
)