package com.example.universityofyogyakarta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ScrollView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

public class MainActivity : AppCompatActivity() {
    private lateinit var rvUniversity: RecyclerView
    private val list = ArrayList<University>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvUniversity = findViewById(R.id.rv_university)
        rvUniversity.setHasFixedSize(true)

        list.addAll(getListUniversity())
        showRecyclerList()
    }

    //main_menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.profile -> {
                //intent activity
                val intent = Intent(this@MainActivity, user::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    //listuniversity
    private fun getListUniversity(): ArrayList<University> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listUniversity = ArrayList<University>()
        for (i in dataName.indices) {
            val university = University(dataName[i], dataDescription[i], dataPhoto[i])
            listUniversity.add(university)
        }
        return listUniversity
    }

    private fun showRecyclerList() {
        rvUniversity.layoutManager = LinearLayoutManager(this)
        val listUniversityAdapter = ListUniversityAdapter(list)
        rvUniversity.adapter = listUniversityAdapter

        listUniversityAdapter.setOnItemClickCallback(object : ListUniversityAdapter.OnItemClickCallback {
            override fun onItemClicked(data: University) {

                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                    .putExtra("EXTRA_NAME", data.name)
                    .putExtra("EXTRA_DES", data.description)
                    .putExtra("EXTRA_PHOTO", data.photo)
                startActivity(intent)
            }
        })
    }
}