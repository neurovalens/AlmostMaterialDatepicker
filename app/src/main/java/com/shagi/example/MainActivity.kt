package com.shagi.example

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.shagi.materialdatepicker.databinding.ActivityMainBinding
import com.shagi.materialdatepicker.date.DatePickerFragmentDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val dialog = DatePickerFragmentDialog.newInstance({ _, year, monthOfYear, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, monthOfYear, dayOfMonth)

                val simpleDateFormat = SimpleDateFormat("yyyy-MMM-dd", Locale.getDefault())

                Toast.makeText(applicationContext, simpleDateFormat.format(calendar.time), Toast.LENGTH_SHORT).show()
            }, 2017, 11, 4)
            dialog.show(supportFragmentManager, "tag")
        }
    }
}
