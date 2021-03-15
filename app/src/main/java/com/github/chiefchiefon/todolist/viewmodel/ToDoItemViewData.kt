package com.github.chiefchiefon.todolist.viewmodel

data class ToDoItemViewData(val id: Int?, val itemText: String, val isCompleted: Boolean)

// Orel's code

//data class ToDoItemViewData(
//    val id: Int,
//    val text: String,
//    val isDone: Boolean
//)

data class ToDoListViewData (
    val itemsList: List<ToDoItemViewData> = emptyList()
        )