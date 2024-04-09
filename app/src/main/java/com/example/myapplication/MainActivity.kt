package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.Data.Cliente
import com.example.myapplication.Data.listaClientes
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            val sucessoLogin =
                login(binding.nomeInserido, binding.senhaInserida, listaClientes)

            if (sucessoLogin) {
                showToast(this,"ok", 1)

            }else{
                showToast(this,"no", 1)
            }
        }
    }

}

fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}

fun login(
    editTextUsername: EditText,
    editTextPass: EditText,
    listaClientes: List<Cliente>
): Boolean {
    val username = editTextUsername.text.toString()
    val senha = editTextPass.text.toString()

    val verificarUser = listaClientes.find { it.nome == username }

    if (verificarUser == null) {
        return false
    }

    return verificarUser.senha == senha
}