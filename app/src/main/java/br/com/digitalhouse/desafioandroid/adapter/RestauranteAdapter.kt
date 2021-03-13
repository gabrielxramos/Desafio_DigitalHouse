package br.com.digitalhouse.desafioandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafioandroid.R
import br.com.digitalhouse.desafioandroid.ui.Restaurante

class RestauranteAdapter (
    private val listaEntrada: List<Restaurante>,
    private val restauranteClickListener: OnRestauranteClickListener
    ): RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestauranteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_restaurante, parent,false)
        return RestauranteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val currentItem = listaEntrada[position]
        holder.ivRestaurante.setOnClickListener{
            restauranteClickListener.onRestauranteClick(position)
        }
        holder.ivRestaurante.setImageResource(currentItem.imagem)
        holder.tvNomeRestaurante.text =currentItem.local
        holder.tvEnderecoRestaurante.text = currentItem.endereco
        holder.tvHorarioRestaurante.text = currentItem.horario
    }

    inner class RestauranteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val ivRestaurante: ImageView = itemView.findViewById(R.id.ivRestaurante)
        val tvNomeRestaurante: TextView = itemView.findViewById(R.id.tvNomeRestaurante)
        val tvEnderecoRestaurante: TextView = itemView.findViewById(R.id.tvEnderecoRestaurante)
        val tvHorarioRestaurante: TextView = itemView.findViewById(R.id.tvHorarioRestaurante)

    }

    interface OnRestauranteClickListener {
        fun onRestauranteClick(position: Int)
    }

    override fun getItemCount(): Int {
        return listaEntrada.size
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RestauranteViewHolder{
//        val itemView =
//    }

    }

