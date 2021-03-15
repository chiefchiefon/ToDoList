package com.github.chiefchiefon.todolist.model.db

import androidx.lifecycle.LiveData

class ToDoRepository(private val toDoDao: ToDoDao) {
    enum class ToDoFilter {
        ALL,
        COMPLETED,
        UNCOMPLETED
    }

    fun getToDoItems(toDoFilter: ToDoFilter): LiveData<List<ToDoItem>> {
        return when(toDoFilter) {
            ToDoFilter.ALL -> toDoDao.getAllToDos()
            ToDoFilter.COMPLETED -> toDoDao.findCompletedToDos()
            ToDoFilter.UNCOMPLETED -> toDoDao.findUncompletedToDos()
        }
    }


    fun addToDo(toDoText: String) {
        toDoDao.insert(ToDoItem(itemText = toDoText, priority = 0))
    }

    fun updateToDo(toDoItem: ToDoItem) {
        toDoDao.updateOrCreate(toDoItem)
    }

    fun remove(toDoItem: ToDoItem) {
        toDoDao.delete(toDoItem)
    }
}