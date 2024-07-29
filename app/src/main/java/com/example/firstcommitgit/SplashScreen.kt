package com.example.firstcommitgit

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)
        //Definir o tempo da splash
        val Timer = if (FirstSplashScreen()) 10000 else 3000

        //SplashScreen em funcionamento
        Handler().postDelayed({
            startActivity(Intent(this, Login::class.java))
        }, Timer.toLong())

    }

    // Verifica se é a primeira vez que o aplicativo está sendo lançado
    private fun FirstSplashScreen (): Boolean {
        val sharedPreferences: SharedPreferences = getSharedPreferences("", MODE_PRIVATE)
        val firstSplashScreen = sharedPreferences.getBoolean("firstSplashScreen", true)
        if (firstSplashScreen) {
            sharedPreferences.edit().putBoolean("firstSplashScreen", false).apply()
        }
        return firstSplashScreen
    }
}