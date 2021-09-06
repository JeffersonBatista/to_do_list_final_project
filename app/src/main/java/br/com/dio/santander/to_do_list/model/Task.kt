package br.com.dio.santander.to_do_list.model

data class Task(
    val title: String,
    val description: String,
    val date: String,
    val hour: String,
    val id: Int = 0

)
