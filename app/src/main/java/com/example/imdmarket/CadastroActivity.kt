package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.database.Produto
import com.example.imdmarket.database.ProdutoFileHelper

class CadastroActivity : AppCompatActivity() {
    private lateinit var produtos: MutableList<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        produtos = ProdutoFileHelper.carregarProdutos(this)

        val edtCodigo = findViewById<EditText>(R.id.edtCodigo)
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtDescricao = findViewById<EditText>(R.id.edtDescricao)
        val edtEstoque = findViewById<EditText>(R.id.edtEstoque)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnLimpar.setOnClickListener {
            edtCodigo.text.clear()
            edtNome.text.clear()
            edtDescricao.text.clear()
            edtEstoque.text.clear()
        }

        btnSalvar.setOnClickListener {
            val codigo = edtCodigo.text.toString()
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()
            val estoque = edtEstoque.text.toString().toIntOrNull()

            if (codigo.isNotBlank() && nome.isNotBlank() && descricao.isNotBlank() && estoque != null) {
                val novoProduto = Produto(codigo, nome, descricao, estoque)

                // Evita duplicatas
                if (produtos.any { it.codigoProduto == codigo }) {
                    Toast.makeText(this, "Produto com este código já existe!", Toast.LENGTH_SHORT).show()
                } else {
                    produtos.add(novoProduto)
                    ProdutoFileHelper.salvarProdutos(this, produtos)
                    Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


