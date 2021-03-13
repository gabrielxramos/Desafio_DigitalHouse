package br.com.digitalhouse.desafioandroid.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.digitalhouse.desafioandroid.R
import br.com.digitalhouse.desafioandroid.ui.Prato

class PratoAdapter (
    private val listEntrada: List<Prato>,
    private val mOnpratoClickListener: OnPratoClickListenner
    ): RecyclerView.Adapter<PratoAdapter.PratoViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_prato, parent, false)
        return PratoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratoViewHolder, position: Int) {
        val currentItem = listEntrada[position]
        holder.ivPrato.setOnClickListener{
            mOnpratoClickListener.onPratoClick(position)
        }
        holder.ivPrato.setImageResource(currentItem.imagem)
        holder.tvNomePrato.text = currentItem.nome
    }

    override fun getItemCount(): Int {
        return listEntrada.size
    }

    inner class PratoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ivPrato: ImageView = itemView.findViewById(R.id.ivPrato)
        val tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)

    }

    interface OnPratoClickListenner{
        fun onPratoClick(position: Int)
    }


    }