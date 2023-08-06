package com.example.pilihmenuresto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AdapterMenuMakanan(
    private val listMakanan: ArrayList<Menu>,
    private val onItemClick: (Menu) -> Unit
) : RecyclerView.Adapter<AdapterMenuMakanan.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (listMenu, listDescription,listHarga, listFoto) = listMakanan[position]
        if (listFoto != null) {
            holder.imgPhoto.setImageResource(listFoto)
        }
        holder.tvlistMenu.text = listMenu
        holder.tvDescription.text = listDescription
        holder.tvlistHarga.text = listHarga.toString()

    }

    override fun getItemCount(): Int = listMakanan.size
inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    var tvlistMenu: TextView = itemView.findViewById(R.id.tv_item_name)
    var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    var tvlistHarga: TextView = itemView.findViewById(R.id.tv_harga)

    init {
        itemView.findViewById<Button>(R.id.button).setOnClickListener {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                onItemClick(listMakanan[position])
            }
        }
    }
}
}