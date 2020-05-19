package com.dicoding.picodiploma.oldbicycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListBicycleAdapter(private val listBicycle: ArrayList<Bicycle>) :
    RecyclerView.Adapter<ListBicycleAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_bicycle, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBicycle.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.bind(listBicycle[position])
        holder.itemView.setOnClickListener() {
            onItemClickCallback
                .onItemClick(listBicycle[holder.adapterPosition])
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvCountry: TextView = itemView.findViewById(R.id.tv_item_country)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvDetailed: TextView = itemView.findViewById(R.id.tv_item_detail)

        fun bind(bicycle: Bicycle) {
            with(itemView) {
                tvName.text = bicycle.name
                tvCountry.text = bicycle.country
                tvDetailed.text = bicycle.detail
                Glide.with(this).load(bicycle.photo).into(imgPhoto)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClick(data: Bicycle)
    }
}

