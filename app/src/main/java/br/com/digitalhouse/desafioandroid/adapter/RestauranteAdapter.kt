package br.com.digitalhouse.desafioandroid.adapter

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafioandroid.R
import br.com.digitalhouse.desafioandroid.ui.Restaurante
import kotlinx.android.synthetic.main.card_restaurante.view.*

class RestauranteAdapter (
    private val listaEntrada: List<Restaurante>,
    private val RestauranteClickListener: OnRestauranteClickListener
    ): RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestauranteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_restaurante, parent,false)
        return RestauranteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val currentItem = listaEntrada[position]
        holder.ivRestaurante.setOnClickListener{
            RestauranteClickListener.onRestauranteClick(position)
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

