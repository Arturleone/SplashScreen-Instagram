package com.example.firstcommitgit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val botaoLogin = findViewById<Button>(R.id.Login)
        val botaoCadastro = findViewById<Button>(R.id.Cadastrar)
        val Usuario = findViewById<EditText>(R.id.usuario)
        val Senha = findViewById<EditText>(R.id.senha)

        botaoLogin.setOnClickListener {
            var inputUsur = Usuario.text.toString()
            var inputSenh = Senha.text.toString()
            if () {

            }
        }

        botaoCadastro.setOnClickListener {
            startActivity(Intent(this, Cadastro::class.java))
            finish()
        }
    }
}