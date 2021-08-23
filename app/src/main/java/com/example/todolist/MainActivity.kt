package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = ToDoAdapter(mutableListOf())

    recyclerViewToDo.adapter = todoAdapter
    recyclerViewToDo.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener {
            val todoTitle = editToDoItem.text.toString()
            if (todoTitle.isNotEmpty()){
                val toDo = ToDo(todoTitle)
                todoAdapter.addTodo(toDo)
                editToDoItem.text.clear()
            }
        }

        deleteBtn.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }

    }
}