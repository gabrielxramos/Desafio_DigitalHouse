package br.com.digitalhouse.desafioandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.digitalhouse.desafioandroid.R
import kotlinx.android.synthetic.main.activity_prato.*

class PratoActivity : AppCompatActivity() {

    private lateinit var restaurante: Restaurante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato)

        val extras = intent.extras
        val prato = extras?.getSerializable("prato") as Prato
        restaurante = extras.getSerializable("restaurante") as Restaurante

        logoPrato.setImageResource(prato.imagem)
        tvNomePrato.text = prato.nome
        tvDescricaoPrato.text = prato.descricao

        icBack.setOnClickListener{
            Intent(this, RestauranteActivity::class.java).apply {
                putExtra("restaurante", restaurante)
                startActivity(this)
            }
        }

    }
}