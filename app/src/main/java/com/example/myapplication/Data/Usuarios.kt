package com.example.myapplication.Data

import android.widget.EditText

data class Cliente(val nome:String ,val senha:String, val saldo:Double)

val listaClientes = mutableListOf<Cliente>()

fun main() {
    listaClientes.add(Cliente("guilherme", "1748", 120.00))
    listaClientes.add(Cliente("matheus", "1020", 200.00))
}