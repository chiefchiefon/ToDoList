package com.github.chiefchiefon.todolist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoItem (
    /**
     * We'llalways use id, because it accelerate the access to DB
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val itemText: String,
    val isCompleted: Boolean
)