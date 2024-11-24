package com.example.imdmarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.btnCadastro).setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        findViewById<Button>(R.id.btnAlteracao).setOnClickListener {
            startActivity(Intent(this, AlteracaoActivity::class.java))
        }

        findViewById<Button>(R.id.btnExclusao).setOnClickListener {
            startActivity(Intent(this, ExclusaoActivity::class.java))
        }

        findViewById<Button>(R.id.btnListagem).setOnClickListener {
            startActivity(Intent(this, ListagemActivity::class.java))
        }
    }
}
