package br.com.digitalhouse.desafioandroid.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.digitalhouse.desafioandroid.R
import br.com.digitalhouse.desafioandroid.adapter.RestauranteAdapter
import kotlinx.android.synthetic.main.activity_main.*

const val RESTAURANTE = "restaurante"

class MainActivity : AppCompatActivity(), RestauranteAdapter.OnRestauranteClickListener {

    private val listaDeRestaurantes = getListaDeRestaurantes()
    private val restauranteAdapter by lazy { RestauranteAdapter(listaDeRestaurantes, this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcRestaurantes.adapter = restauranteAdapter
    }

    fun getListaDeRestaurantes(): List<Restaurante> {

        val restauranteUm = Restaurante(
            R.mipmap.image_one,
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00"
        )
        val restauranteDois = Restaurante(
            R.mipmap.image_two,
            "Aoyama - Moema",
            "Alameda dos Arapanés, 532 - Moema",
            "Fecha às 00:00"
        )
        val restauranteTres = Restaurante(
            R.mipmap.image_three,
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00"
        )
        val restauranteQuatro = Restaurante(
            R.mipmap.image_four,
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00"
        )
        return listOf(restauranteUm, restauranteDois, restauranteTres, restauranteQuatro)
    }

    override fun onRestauranteClick(position: Int) {
        Intent(this, RestauranteActivity::class.java).apply {
            putExtra(RESTAURANTE, listaDeRestaurantes[position])
            startActivity(this)
        }
    }

}