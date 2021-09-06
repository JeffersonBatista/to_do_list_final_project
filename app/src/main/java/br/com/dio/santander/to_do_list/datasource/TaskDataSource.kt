package br.com.dio.santander.to_do_list.datasource

import br.com.dio.santander.to_do_list.model.Task

object TaskDataSource{
    private val list = arrayListOf<Task>()

    fun getList() = list

    fun insertTask(task: Task){
        list.add(task.copy(id = list.size + 1))
    }
}