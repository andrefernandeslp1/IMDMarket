package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.database.Produto
import com.example.imdmarket.database.ProdutoFileHelper

class AlteracaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alteracao)

        val edtCodigo = findViewById<EditText>(R.id.edtCodigo)
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtDescricao = findViewById<EditText>(R.id.edtDescricao)
        val edtEstoque = findViewById<EditText>(R.id.edtEstoque)
        val btnAlterar = findViewById<Button>(R.id.btnAlterar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnLimpar.setOnClickListener {
            edtCodigo.text.clear()
            edtNome.text.clear()
            edtDescricao.text.clear()
            edtEstoque.text.clear()
        }

        btnAlterar.setOnClickListener {
            val codigo = edtCodigo.text.toString().trim()

            // Verifica se o campo de código foi preenchido
            if (codigo.isBlank()) {
                Toast.makeText(this, "Código do produto é obrigatório.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Carrega os produtos para buscar o produto existente
            val produtos = ProdutoFileHelper.carregarProdutos(this)
            val produtoExistente = produtos.find { it.codigoProduto == codigo }

            if (produtoExistente == null) {
                Toast.makeText(this, "Produto não encontrado. Verifique o código.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Atualiza apenas os campos que foram preenchidos
            val nome = edtNome.text.toString().trim()
            val descricao = edtDescricao.text.toString().trim()
            val estoque = edtEstoque.text.toString().toIntOrNull()

            if (nome.isNotBlank()) produtoExistente.nomeProduto = nome
            if (descricao.isNotBlank()) produtoExistente.descricaoProduto = descricao
            if (estoque != null) produtoExistente.quantidadeEstoque = estoque

            // Salva os produtos atualizados
            ProdutoFileHelper.salvarProdutos(this, produtos)

            Toast.makeText(this, "Produto alterado com sucesso.", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
