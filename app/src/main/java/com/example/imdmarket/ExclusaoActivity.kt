package com.example.imdmarket

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.imdmarket.database.Produto
import com.example.imdmarket.database.ProdutoFileHelper

class ExclusaoActivity : AppCompatActivity() {
    private lateinit var produtos: MutableList<Produto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exclusao)

        produtos = ProdutoFileHelper.carregarProdutos(this)

        val edtCodigo = findViewById<EditText>(R.id.edtCodigo)
        val btnDeletar = findViewById<Button>(R.id.btnDeletar)

        btnDeletar.setOnClickListener {
            val codigo = edtCodigo.text.toString()
            val produto = produtos.find { it.codigoProduto == codigo }

            if (produto != null) {
                produtos.remove(produto)
                ProdutoFileHelper.salvarProdutos(this, produtos)
                Toast.makeText(this, "Produto excluído com sucesso!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Produto não encontrado!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

