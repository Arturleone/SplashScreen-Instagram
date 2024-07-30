package com.example.firstcommitgit

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Login : AppCompatActivity() {
    private var tentativas = 0
    private var timer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        val botaoLogin = findViewById<Button>(R.id.Login)
        val botaoCadastro = findViewById<Button>(R.id.CadastrarLogin)
        val Usuario = findViewById<EditText>(R.id.usuarioLogin)
        val Senha = findViewById<EditText>(R.id.senha)


        botaoLogin.setOnClickListener {
            var inputUsur = Usuario.text.toString()
            var inputSenh = Senha.text.toString()
            if (validateLogin(inputUsur, inputSenh)) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("Username", inputUsur)
                startActivity(intent)
                finish()
            } else {
                tentativas++
                if (tentativas > 3) {
                    for (i in 10 downTo 10) {
                        Toast.makeText(this, "Login Bloqueado Por ${timer + 10}  segundos", Toast.LENGTH_SHORT).show()
                        Handler().postDelayed({}, 1000)
                    }
                    botaoLogin.isEnabled = false
                    botaoCadastro.isEnabled = false
                    tentativas = 0
                    timer = 10
                }
            }
        }

        botaoCadastro.setOnClickListener {
            startActivity(Intent(this, Cadastro::class.java))
            finish()
        }

    }
    private fun validateLogin (usuario: String, senha: String): Boolean {
        val sharedPreferences: SharedPreferences = getSharedPreferences("", MODE_PRIVATE)
        val validatedSenha = sharedPreferences.getString("Senha", null)
        val validatedUsu = sharedPreferences.getString("Usuario", null)
        if (validatedUsu == usuario && validatedSenha == senha) {
            return true
        } else return false
    }
}