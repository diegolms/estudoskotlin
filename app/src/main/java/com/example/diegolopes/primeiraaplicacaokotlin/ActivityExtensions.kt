package com.example.diegolopes.primeiraaplicacaokotlin

import android.app.Activity
import android.widget.Toast

fun Activity.showShortToast(text : String){
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}
