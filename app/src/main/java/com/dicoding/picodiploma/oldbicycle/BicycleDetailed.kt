package com.dicoding.picodiploma.oldbicycle

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_detail_bicycle.*
import kotlinx.android.synthetic.main.item_row_bicycle.*
import kotlinx.android.synthetic.main.item_row_bicycle.img_item_photo
import kotlinx.android.synthetic.main.item_row_bicycle.tv_item_name


class BicycleDetailed : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DETAILED = "extra_detailed"
        const val EXTRA_IMAGE_URL = "extra_image_url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_detail_bicycle)
//
//        var name = intent.getStringExtra("name")
//        var detail = intent.getStringExtra("detail")


//        var tvName:TextView = findViewById(R.id.tv_item_name)
//        var tvDetail:TextView= findViewById(R.id.tv_item_detail)
//
//        tvName.text = name.toString()
//        tvDetail.text = detail.toString()

        showBicycleDetail()
    }

   private fun showBicycleDetail() {
      tv_item_name.setText(intent.getStringExtra(EXTRA_NAME))
        tv_item_detail.setText(intent.getStringExtra(EXTRA_DETAILED))

        Glide.with(this)
            .load(intent.getStringExtra(EXTRA_IMAGE_URL)).into(img_item_photo)
    }
}



