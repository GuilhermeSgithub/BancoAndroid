package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.Data.Cliente
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val listaClientes = mutableListOf<Cliente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listaClientes.add(Cliente("guilherme", "1748", 120.00))
        listaClientes.add(Cliente("matheus", "1020", 200.00))

        binding.run {
            button.setOnClickListener {
                val sucessoLogin = login(
                    username = nomeInserido.text.toString(),
                    senha = senhaInserida.text.toString(),
                    listaClientes = listaClientes
                )

                if (sucessoLogin) {
                    val intent = Intent(this@MainActivity, MenuActivity::class.java)
                    startActivity(intent)
                } else {
                    showToast(
                        this@MainActivity,
                        "Usuário Não Cadastrado, Tente Novamente",
                        1
                    )
                }
            }
        }
    }
}

fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}

fun login(
    username: String,
    senha: String,
    listaClientes: List<Cliente>
): Boolean {

    val verificarUser = listaClientes.find { it.nome == username }

    return verificarUser != null && verificarUser.senha == senha
}
