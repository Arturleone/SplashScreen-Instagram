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
                showError("As senhas não estão iguais")
            } else if (!isValidPassword(inputSenha)) {
                showError("A senha tem que ter mais de 6 caracteres, uma letra maiúscula, 3 números, duas letras e um caracter especial")
            } else {
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, Login::class.java))
                User(inputUsuario, inputSenha)
                finish()
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
        val SanitizedPassword = senha.replace(" ", "")
        if (senha.length < 6) return false //Saber se a senha é maior do que 6 dígitos
        if (!senha.any { it.isUpperCase() }) return false //Se a senha possui ao menos uma letra maiúscula
        if (senha.count { it.isDigit() } < 3) return false // tem que ter no mínimo 3 números
        if (senha.count { it.isLetter() } < 2) return false //ao menos duas letra
        if (!senha.any { !it.isLetterOrDigit() }) return false //ao menos um caracter especial
        return true
    }
}