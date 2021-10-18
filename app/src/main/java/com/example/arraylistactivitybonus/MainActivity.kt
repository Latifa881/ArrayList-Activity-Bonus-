package com.example.arraylistactivitybonus

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etName: EditText
    lateinit var etGetName: EditText
    lateinit var btAdd: Button
    lateinit var btGetName: Button
    lateinit var tvName: TextView
    val names = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etName = findViewById(R.id.etName)
        etGetName = findViewById(R.id.etGetName)
        btAdd = findViewById(R.id.btAdd)
        btGetName = findViewById(R.id.btGetName)
        tvName = findViewById(R.id.tvName)

        btAdd.setOnClickListener {
            val name = etName.text.toString()
            etName.setText("")
            if (name.isNotEmpty()) {
                names.add(name)
            } else {
                Toast.makeText(this, "Enter a name", Toast.LENGTH_SHORT).show()
            }
        }
        btGetName.setOnClickListener {
            val text = etGetName.text.toString()
            etGetName.setText("")
            if (text.isNotEmpty()) {
                val number = text.toInt()
                try {
                    tvName.setText(names[number - 1])
                    tvName.setTextColor(getResources().getColor(R.color.teal_700))
                } catch (e: Exception) {
                    tvName.setText("No Name with this index found!")
                    tvName.setTextColor(Color.RED)
                }
            } else {
                Toast.makeText(this, "Enter an index (Number)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}