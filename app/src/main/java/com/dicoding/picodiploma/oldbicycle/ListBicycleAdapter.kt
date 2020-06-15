package com.dicoding.picodiploma.oldbicycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row_bicycle.view.*

class ListBicycleAdapter(val listBicycle: ArrayList<Bicycle>) :
    RecyclerView.Adapter<ListBicycleAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        i: Int
    ): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row_bicycle, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBicycle.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        holder.bind(listBicycle[position])
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClick(listBicycle[holder.adapterPosition])
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
//        var tvCountry: TextView = itemView.findViewById(R.id.tv_item_country)
//        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
//        var tvDetailed: TextView = itemView.findViewById(R.id.tv_item_detail)

        fun bind(bicycle: Bicycle) {
            with(itemView) {
                tv_item_name.text = bicycle.name
                tv_item_country.text = bicycle.country
//                tv_item_detail.text = bicycle.detail
//                img_item_photo. = bicycle.photo
                Glide.with(this)
                    .load(bicycle.photo)
                    .into(img_item_photo)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClick(data: Bicycle)
    }
}

