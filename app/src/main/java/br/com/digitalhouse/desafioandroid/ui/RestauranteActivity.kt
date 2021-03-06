package br.com.digitalhouse.desafioandroid.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.digitalhouse.desafioandroid.R
import br.com.digitalhouse.desafioandroid.adapter.PratoAdapter
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity(),PratoAdapter.OnPratoClickListenner {

    private var restaurante: Restaurante? = null
    private var listaPratos = getListaPrato()
    private val pratoAdapter by lazy { PratoAdapter(listaPratos, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        val extras = intent.extras
        restaurante = extras?.getSerializable(RESTAURANTE) as Restaurante
        nomeRestaurante.text = restaurante?.local

        restaurante?.imagem?.let { img->
            logoRestaurante.setImageDrawable(getDrawable(img))
        }

        rvPratos.adapter = pratoAdapter

        voltarParaRestaurantes.setOnClickListener {
            onNavigateUp()
            Intent(this, MainActivity::class.java).apply {
                putExtra("main", restaurante)
                startActivity(this)
            }
        }
    }

    override fun onPratoClick(position: Int) {
        Intent(this, PratoActivity::class.java).apply {
            putExtra("prato", listaPratos[position])
            putExtra("restaurante", restaurante)
            startActivity(this)
        }
    }

    private fun getListaPrato(): ArrayList<Prato>{
        val prato = Prato(
            R.mipmap.image_four,
            "Waffle com Ovo",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoDois = Prato(
            R.mipmap.image_one,
            "Porção de Camarão",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoTres = Prato(
            R.mipmap.image_three,
            "Hamburguer",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoQuatro = Prato(
            R.mipmap.imagem_vegano,
            "Ovo Vegano",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoCinco = Prato(
            R.mipmap.panquequinha_da_vovo,
            "Panquequinha da Vovó",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoSeis = Prato(
            R.mipmap.image_uou,
            "Mignon ao Molho",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoSete = Prato(
            R.mipmap.imagem_camarao,
            "Bobó de Camarão",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )

        val pratoOito = Prato(
            R.mipmap.imagem_medalhao,
            "Vaca Atolada",
            "Mussum Ipsum, cacilds vidis litro abertis. Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Paisis, filhis, espiritis santis. Viva Forevis aptent taciti sociosqu ad litora torquent. Mé faiz elementum girarzis, nisi eros vermeio."
        )
        return arrayListOf(prato, pratoDois, pratoTres, pratoQuatro, pratoCinco, pratoSeis, pratoSete, pratoOito)
    }
}