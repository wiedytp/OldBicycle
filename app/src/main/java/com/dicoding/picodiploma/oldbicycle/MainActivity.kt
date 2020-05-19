package com.dicoding.picodiploma.oldbicycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvBicycle: RecyclerView
    private lateinit var listBicycleAdapter: ListBicycleAdapter
    private var list: ArrayList<Bicycle> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showRecyclerList()
        setListClickAction()
    }

    private fun showRecyclerList() {

        rvBicycle.layoutManager = LinearLayoutManager(this)
        list.addAll(BicycleData.listData)
        val listBicycleAdapter = ListBicycleAdapter(list)
        rvBicycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            rvBicycle.adapter = listBicycleAdapter
            setHasFixedSize(true)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setListClickAction() {
            ListBicycleAdapter.setOnItemClickCallback(object : ListBicycleAdapter.OnItemClickCallback {
                override fun onItemClick(data: Bicycle) {
                    val BicycleDetailed = Intent(this@MainActivity, BicycleDetailed::class.java)
                        .apply {
                            putExtra(BicycleDetailed.EXTRA_NAME, data.name)
                            putExtra(BicycleDetailed.EXTRA_DETAILED, data.detail)
                            putExtra(BicycleDetailed.EXTRA_IMAGE_URL, data.photo)
                        }
                    startActivity(BicycleDetailed)
                }
            })
        }

    private fun showRecyclerGrid() {
        rvBicycle.layoutManager = GridLayoutManager(this, 1)
        val gridBicycleAdapter = GridBicycleAdapter(list)
        rvBicycle.adapter = gridBicycleAdapter
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_profile -> {
                val moveIntent = Intent(this@MainActivity, Profile::class.java)
                startActivity(moveIntent)
            }
            R.id.action_list -> {
                showRecyclerList()
            }
        }
    }
}
