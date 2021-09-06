package br.com.dio.santander.to_do_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.dio.santander.to_do_list.databinding.ActivityMainBinding
import br.com.dio.santander.to_do_list.ui.AddTaskActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners(){
        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddTaskActivity::class.java))
        }
    }
}