package com.dicoding.picodiploma.oldbicycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridBicycleAdapter(private val listBicycle: ArrayList<Bicycle>) : RecyclerView.Adapter<GridBicycleAdapter.GridViewHolder>() {


    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): GridBicycleAdapter.GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_bicycle, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listBicycle.size
    }

    override fun onBindViewHolder(holder: GridBicycleAdapter.GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listBicycle[position].photo)
            .fitCenter()
            .into(holder.imgPhoto)
    }


    inner class GridViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView){
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)

    }
}