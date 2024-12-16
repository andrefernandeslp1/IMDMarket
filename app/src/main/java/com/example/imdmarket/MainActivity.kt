package com.example.imdmarket

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val sharedPreferences = getSharedPreferences("user_credentials", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString("login", "admin")
        editor.putString("password", "admin")
        editor.apply()

        btnLogin.setOnClickListener {
            val usuario = edtUsuario.text.toString()
            val senha = edtSenha.text.toString()

            val savedUsuario = sharedPreferences.getString("login", null)
            val savedSenha = sharedPreferences.getString("password", null)

            if (usuario == savedUsuario && senha == savedSenha) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
