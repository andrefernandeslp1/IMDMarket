package com.example.imdmarket.database

data class Produto(
    val codigoProduto: String,  // Obrigatório
    var nomeProduto: String = "",  // Opcional
    var descricaoProduto: String = "",  // Opcional
    var quantidadeEstoque: Int? = null  // Opcional
)
