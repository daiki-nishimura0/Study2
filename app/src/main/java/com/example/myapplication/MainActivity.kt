package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: Button = findViewById(R.id.add_button)
        val lv: ListView = findViewById(R.id.lv)

        val adapter = ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arrayListOf()
        )
        lv.adapter = adapter

        btnAdd.setOnClickListener {

            val et =  EditText(this)

            AlertDialog.Builder(this)
                    .setTitle("項目")
                    .setMessage("追加")
                    .setMessage("何をする？")
                    .setView(et)
                    .setPositiveButton("追加", DialogInterface.OnClickListener { _, _ ->
                        val myTodo = et.text.toString()
                        adapter.add(myTodo)
                    })
                    .setNegativeButton("キャンセル", null)
                    .show()
        }

        lv.setOnItemClickListener { _, _, i, _ ->
            AlertDialog.Builder(this)
                    .setTitle("削除しますか")
                    .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                        adapter.remove(adapter.getItem(i))
                    })
                    .setNegativeButton("No", null)
                    .show()
        }
    }
}