package br.com.oswaldopaulo.todolist.model

data class Task(
    val title: String,
    val desc : String,
    val hour: String,
    val date: String,
    val id : Int = 0
)