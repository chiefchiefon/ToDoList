package com.github.chiefchiefon.todolist.viewmodel

data class ToDoItemViewData(val id: Int?, val itemText: String, val isCompleted: Boolean, val priority: Int)

// Orel's code

//data class ToDoItemViewData(
//    val id: Int,
//    val text: String,
//    val isDone: Boolean,
//    val priority: Int
//)

data class ToDoListViewData (
    val itemsList: List<ToDoItemViewData> = emptyList()
        )