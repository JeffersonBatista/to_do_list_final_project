package br.com.dio.santander.to_do_list.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.dio.santander.to_do_list.databinding.ActivityAddTaskBinding
import br.com.dio.santander.to_do_list.extensions.format
import br.com.dio.santander.to_do_list.extensions.text
import com.google.android.material.datepicker.MaterialDatePicker
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

    // Método de inserção da data
    private fun insertListeners(){
        binding.inputDate.editText?.setOnClickListener{
            val datePicker = MaterialDatePicker.Builder.datePicker().build()
            datePicker.addOnPositiveButtonClickListener {
                val timeZone = TimeZone.getDefault()
                val offset = timeZone.getOffset(Date().time) * -1
                binding.inputDate.text = Date(it + offset).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }
    }

}