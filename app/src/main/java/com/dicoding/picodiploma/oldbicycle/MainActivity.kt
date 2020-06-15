package com.dicoding.picodiploma.oldbicycle

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
// private lateinit var rvBicycle: RecyclerView
    private var list: ArrayList<Bicycle> = arrayListOf()
    private lateinit var listBicycleAdapter: ListBicycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showRecyclerList()
        setListClickAction()
    }

    private fun showRecyclerList() {

//        rv_bicycle.layoutManager = LinearLayoutManager(this)
        list.addAll(BicycleData.listData)
        listBicycleAdapter = ListBicycleAdapter(list)

        rv_bicycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
           adapter = listBicycleAdapter
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
            listBicycleAdapter.setOnItemClickCallback(object : ListBicycleAdapter.OnItemClickCallback {
                override fun onItemClick(data: Bicycle) {
                    val BicycleDetailed = Intent(this@MainActivity, BicycleDetailed::class.java)
                        .apply {
                            putExtra(BicycleDetailed.EXTRA_NAME, data.name)
                            putExtra(BicycleDetailed.EXTRA_DETAILED, data.detail)
                            putExtra(BicycleDetailed.EXTRA_PHOTO, data.photo)
                        }
                    startActivity(BicycleDetailed)
                }
            })
        }

    private fun showRecyclerGrid() {
        rv_bicycle.layoutManager = GridLayoutManager(this, 1)
        val gridBicycleAdapter = GridBicycleAdapter(list)
        rv_bicycle.adapter = gridBicycleAdapter
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
