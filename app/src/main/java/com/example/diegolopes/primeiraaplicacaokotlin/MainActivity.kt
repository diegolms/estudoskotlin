package com.example.diegolopes.primeiraaplicacaokotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val listPeople : MutableList<Pessoa> by lazy { mutableListOf<Pessoa>() }
    private var adapter : ArrayAdapter<Pessoa>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fabAdd.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivityForResult(intent, REQUEST_INSERT)
        }

        listaPessoas.setOnItemClickListener { _, _, position, _ ->
            showShortToast(listPeople[position].name)
        }

        adapter = ArrayAdapter<Pessoa>(this, android.R.layout.simple_list_item_single_choice, listPeople)
        listaPessoas.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_INSERT && resultCode == Activity.RESULT_OK){
            val pessoa = data?.getSerializableExtra(DetailActivity.EXTRA_PERSON) as? Pessoa
            if(pessoa != null){
                listPeople.add(pessoa)
                listPeople.sortBy { it.name }
                adapter?.notifyDataSetChanged()
            }


        }
    }

    companion object {
        val REQUEST_INSERT = 0
    }


}
