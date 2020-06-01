package com.dicoding.picodiploma.oldbicycle

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_detail_bicycle.*

//import kotlinx.android.synthetic.main.item_row_bicycle.img_item_photo
//import kotlinx.android.synthetic.main.item_row_bicycle.tv_item_name


class BicycleDetailed : AppCompatActivity() {



    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAILED = "extra_detailed"

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_bicycle)


        showBicycleDetail()
    }

    private fun showBicycleDetail() {
        tv_item_name.setText(intent.getStringExtra(EXTRA_NAME))
        tv_item_detail.setText(intent.getStringExtra(EXTRA_DETAILED))

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        fun (bicycle: Bicycle) {
            Glide.with(this)
                .load(bicycle.photo)
                .into(imgPhoto)

        }
        }




}




