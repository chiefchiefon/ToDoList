package com.github.chiefchiefon.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.github.chiefchiefon.todolist.model.AppDataBase
import com.github.chiefchiefon.todolist.model.ToDoItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(this, AppDataBase::class.java, "app-db")
            .allowMainThreadQueries()
            .build()

        db.toDoDao().insert(ToDoItem(null, "Learn SQL", false))
    }
}