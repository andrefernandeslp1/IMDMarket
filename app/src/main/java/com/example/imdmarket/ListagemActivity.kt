package com.example.imdmarket

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_listagem)

        data class Produto(val codigo: Int, val nome: String, val descricao: String, val estoque: Int)

        val produtosExemplo = listOf(
            Produto(1, "Banana", "Banana Prata", 10),
            Produto(2, "Maçã", "Maçã Vermelha", 20),
            Produto(3, "Chiclete", "Goma de mascar", 30),
            Produto(4, "Farinha", "Farinha de mandioca", 40))

        val listaExemplo = produtosExemplo.map { "Código: ${it.codigo} - Nome: ${it.nome}" }

        val listaProdutos = findViewById<ListView>(R.id.listViewProdutos)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaExemplo)
        listaProdutos.adapter = adapter

    }
}