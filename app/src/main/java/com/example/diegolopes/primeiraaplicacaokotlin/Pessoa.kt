package com.example.diegolopes.primeiraaplicacaokotlin

import java.io.Serializable

/**
 * Created by diegolopes on 14/08/17.
 */

data class Pessoa(var name : String, var idade : Int) : Serializable{
    override fun toString(): String {
        return "$name - $idade"
    }
}

