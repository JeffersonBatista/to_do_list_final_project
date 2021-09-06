package br.com.dio.santander.to_do_list.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import br.com.dio.santander.to_do_list.databinding.ActivityAddTaskBinding
import br.com.dio.santander.to_do_list.datasource.TaskDataSource
import br.com.dio.santander.to_do_list.extensions.format
import br.com.dio.santander.to_do_list.extensions.text
import br.com.dio.santander.to_do_list.model.Task
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    // Primeiro Método do ciclo de vida de uma activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    // Método de inserção das funções de click
    private fun insertListeners(){
        //Inserção da data
        binding.inputDate.editText?.setOnClickListener{
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.inputDate.text = Date(it + offset).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        //Inserção da hora
        binding.inputHour.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .build()
            timePicker.addOnPositiveButtonClickListener{
                val hour = if(timePicker.hour in 0..9) "0${timePicker.hour}" else timePicker.hour
                val minute = if(timePicker.minute in 0..9) "0${timePicker.minute}" else timePicker.minute
                binding.inputHour.text = "$hour:$minute"
            }
            timePicker.show(supportFragmentManager, null)
        }

        //Criar tarefa
        binding.btnCreate.setOnClickListener{
            val task = Task(
                title = binding.inputTitle.text,
                description = binding.inputDescription.text,
                date = binding.inputDate.text,
                hour = binding.inputHour.text
            )
            TaskDataSource.insertTask(task)
            setResult(Activity.RESULT_OK)
            finish()
        }

        //Cancelar
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

}