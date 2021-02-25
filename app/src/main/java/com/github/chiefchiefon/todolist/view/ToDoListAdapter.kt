package com.github.chiefchiefon.todolist.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.todolist.R
import com.github.chiefchiefon.todolist.viewmodel.ToDoItemViewData

class ToDoListAdapter : ListAdapter<ToDoItemViewData, ToDoListAdapter.ViewHolder>(ToDoDiffUtil()) {

    var clickListener: ((Int) -> Unit)? = null

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val toDoId: TextView = view.findViewById(R.id.todo_id_TV)
        private val toDoText: TextView = view.findViewById(R.id.todo_text_TV)
        private val isCompletedCheckBox: CheckBox = view.findViewById(R.id.isCompleted_CB)

        fun bind(toDoItemViewData: ToDoItemViewData) {
            toDoId.text = toDoItemViewData.id.toString()
            toDoText.text = toDoItemViewData.itemText
            isCompletedCheckBox.isChecked = toDoItemViewData.isCompleted
        }
    }

    class ToDoDiffUtil : DiffUtil.ItemCallback<ToDoItemViewData>() {
        override fun areItemsTheSame(oldItem: ToDoItemViewData, newItem: ToDoItemViewData): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ToDoItemViewData, newItem: ToDoItemViewData): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_todo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))

        holder.itemView.setOnClickListener {
            if (getItem(position).id != null)
                clickListener?.invoke(getItem(position).id!!)
            else
                Log.e("ERROR id", "id not found")
        }
    }

}