package com.github.chiefchiefon.todolist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.chiefchiefon.todolist.model.db.ToDoRepository

class ToDoViewModelFactory(private val repository: ToDoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ToDoViewModel(repository) as T
    }
}