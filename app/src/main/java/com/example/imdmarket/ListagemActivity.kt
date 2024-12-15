package com.example.imdmarket

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.database.ProdutoFileHelper

class ListagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listagem)

        val produtos = ProdutoFileHelper.carregarProdutos(this)
        val listView = findViewById<ListView>(R.id.listViewProdutos)

        val listaExemplo = produtos.map { "Código: ${it.codigoProduto} - Nome: ${it.nomeProduto}" }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaExemplo)
        listView.adapter = adapter

    }
}