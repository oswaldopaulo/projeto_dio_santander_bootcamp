package br.com.oswaldopaulo.todolist.ui

import android.os.Bundle
import android.util.Log
import android.widget.TimePicker
import androidx.appcompat.app.AppCompatActivity
import br.com.oswaldopaulo.todolist.databinding.ActivityAddTaskBinding
import br.com.oswaldopaulo.todolist.extensions.format
import br.com.oswaldopaulo.todolist.extensions.text
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat

import java.util.*

class AddTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners();
    }

    private fun insertListeners() {
        binding.tilDate.editText?.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker().build()

            datePicker.addOnPositiveButtonClickListener {

                binding.tilDate.text =  Date(
                        it +  TimeZone.getDefault().getOffset(Date().time) * -1
                        ).format()
            }
            datePicker.show(supportFragmentManager, "DATE_PICKER_TAG")
        }

        binding.tilHour.editText?.setOnClickListener {
            val timePicker = MaterialTimePicker.Builder()
                    .setTimeFormat(TimeFormat.CLOCK_24H)
                    .build()

            timePicker.addOnPositiveButtonClickListener {
                binding.tilHour.text = "${timePicker.hour} ${timePicker.minute}"

            }

            timePicker.show(supportFragmentManager, null)
        }

        binding.btnCancel.setOnClickListener{
            finish()
        }

        binding.btnNewTask.setOnClickListener {

        }
    }
}