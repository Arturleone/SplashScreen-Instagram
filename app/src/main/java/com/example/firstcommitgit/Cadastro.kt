package com.example.firstcommitgit

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro)
        val Cadastrar = findViewById<Button>(R.id.Cadastrar)
        val Voltar = findViewById<TextView>(R.id.Voltar)
        val Usuario = findViewById<EditText>(R.id.usuario)
        val Senha = findViewById<EditText>(R.id.senhaCadastro)
        val confirmSenha = findViewById<EditText>(R.id.confirmSenha)


        Voltar.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
            finish()
        }

        Cadastrar.setOnClickListener {
            val inputUsuario = Usuario.text.toString()
            val inputSenha = Senha.text.toString()
            val inputConfirmSenha = confirmSenha.text.toString()
            if (inputUsuario == null || inputConfirmSenha == null || inputSenha == null) {
                showError("Todos os campos são obrigatórios!")
            } else if (inputSenha != inputConfirmSenha) {

            } else if () {

            } else {
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
                User(inputUsuario, inputSenha)
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun User(usuario: String, senha: String) {
        val sharedPreferences: SharedPreferences = getSharedPreferences("Pref", MODE_PRIVATE)
        val Editor = sharedPreferences.edit()
        Editor.putString("Usuario", usuario)
        Editor.putString("Senha", senha)
        Editor.apply()
    }

    private fun isValidPassword (senha: String): Boolean {
        if (senha.length < 8) return false
        if (senha.any()) return false
        if (senha.length < 8) return false
        if (senha.length < 8) return false

    }


}