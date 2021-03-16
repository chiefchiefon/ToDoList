package com.github.chiefchiefon.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.todolist.model.db.RoomCreator
import com.github.chiefchiefon.todolist.model.db.ToDoRepository
import com.github.chiefchiefon.todolist.view.ToDoListAdapter
import com.github.chiefchiefon.todolist.viewmodel.ToDoItemViewData
import com.github.chiefchiefon.todolist.viewmodel.ToDoViewModel
import com.github.chiefchiefon.todolist.viewmodel.ToDoViewModelFactory

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<ToDoViewModel> {
        val toDoDao = RoomCreator
            .getDb(this)
            .toDoDao()
        ToDoViewModelFactory(ToDoRepository(toDoDao))
    }

    private val toDoListAdapter by lazy { ToDoListAdapter(this::onTodoChanged) }

    private fun onTodoChanged(toDoItemViewData: ToDoItemViewData) {
        viewModel.onToDoChanged(toDoItemViewData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toDoListView: RecyclerView = findViewById(R.id.itemsList)
        toDoListView.adapter = toDoListAdapter

        viewModel.listLiveData.observe(this) { viewState ->
            toDoListAdapter.submitList(viewState.itemsList)
        }

        val addItemEditText: EditText = findViewById(R.id.addItemET)
        val addItemBtn: Button = findViewById(R.id.addItemBtn)

        addItemBtn.setOnClickListener {
            viewModel.onItemClicked(addItemEditText.text.toString())
            addItemEditText.text = null
        }
    }
}