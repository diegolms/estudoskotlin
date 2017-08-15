package com.example.diegolopes.primeiraaplicacaokotlin

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        btnSalvar.setOnClickListener {
            val nome = editNome.text.toString()
            val idade = editIdade.text.toString().toInt()
            val pessoa = Pessoa(nome,idade)

            val intent = Intent()
            intent.putExtra(EXTRA_PERSON, pessoa)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }


    }

    companion object {
        val EXTRA_PERSON = "pessoa"
    }
}
