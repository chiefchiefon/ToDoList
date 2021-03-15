package com.github.chiefchiefon.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.chiefchiefon.todolist.model.db.ToDoItem
import com.github.chiefchiefon.todolist.model.db.ToDoRepository
import kotlinx.coroutines.launch

class ToDoViewModel(private val repository: ToDoRepository) : ViewModel() {
    val listLiveData = repository
        .getToDoItems(ToDoRepository.ToDoFilter.ALL)
        .map { ToDoListViewData(convertToViewData(it))}

//    fun bindListViewData(filter: ToDoRepository.ToDoFilter): LiveData<ToDoItemViewData> = repository
//        .getToDoItems(filter)
//        .map { ToDoItemViewData(convertToViewData(it)) }

    private fun convertToViewData(entityList: List<ToDoItem>): List<ToDoItemViewData> {
        return entityList.mapNotNull { entity ->
            entity.takeIf { it.id != null }?.let {
                ToDoItemViewData(
                    id = it.id!!,
                    itemText = it.itemText,
                    isCompleted = it.isCompleted,
                    priority = it.priority
                )
            }
        }
    }

    fun onToDoChanged(toDoItemViewData: ToDoItemViewData) {

        viewModelScope.launch{
            ToDoItem(
                toDoItemViewData.id,
                toDoItemViewData.itemText,
                toDoItemViewData.isCompleted,
                0
            )
        }
    }

    fun onItemClicked(textToAdd: String) {
        viewModelScope.launch {
            repository.addToDo(textToAdd)
        }
    }
}