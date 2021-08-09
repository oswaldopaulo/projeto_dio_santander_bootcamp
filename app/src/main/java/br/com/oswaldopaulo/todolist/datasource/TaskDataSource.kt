package br.com.oswaldopaulo.todolist.datasource

import br.com.oswaldopaulo.todolist.model.Task

object  TaskDataSource {
    private val list =  arrayListOf<Task>()

    fun getList() = list

    fun insertTask(task: Task) {
        list.add(task.copy(id=list.size+1))
    }
}