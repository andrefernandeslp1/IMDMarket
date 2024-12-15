package com.example.imdmarket.database

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

object ProdutoFileHelper {
    private const val FILE_NAME = "produtos"

    fun salvarProdutos(context: Context, produtos: List<Produto>) {
        val file = File(context.filesDir, FILE_NAME)
        val json = Gson().toJson(produtos)
        file.writeText(json)
    }

    fun carregarProdutos(context: Context): MutableList<Produto> {
        val file = File(context.filesDir, FILE_NAME)
        if (!file.exists()) return mutableListOf()
        val json = file.readText()
        val type = object : TypeToken<List<Produto>>() {}.type
        return Gson().fromJson(json, type) ?: mutableListOf()
    }

    fun alterarProduto(context: Context, produto: Produto): Boolean {
        val produtos = carregarProdutos(context)
        val index = produtos.indexOfFirst { it.codigoProduto == produto.codigoProduto }

        return if (index != -1) {
            produtos[index] = produto
            salvarProdutos(context, produtos)
            true // Alteração realizada com sucesso
        } else {
            false // Produto não encontrado
        }
    }
}




