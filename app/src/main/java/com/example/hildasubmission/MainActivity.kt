package com.example.hildasubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvNovel: RecyclerView
    private val list = ArrayList<Novel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNovel = findViewById(R.id.rv_novel)
        rvNovel.setHasFixedSize(true)

        list.addAll(getListNovel())
        showRecyclerList()
    }

    private fun getListNovel(): ArrayList<Novel> {
        val bookName = resources.getStringArray(R.array.book_name)
        val bookDesc = resources.getStringArray(R.array.desc)
        val bookCover = resources.obtainTypedArray(R.array.novel_cover)
        val bookIsbn = resources.getStringArray(R.array.isbn)
        val bookPublisher = resources.getStringArray(R.array.publisher)
        val bookPage = resources.getStringArray(R.array.total_page)
        val bookSize = resources.getStringArray(R.array.size)
        val listNovel = ArrayList<Novel>()
        for (i in bookName.indices){
            val novel = Novel(bookName[i], bookDesc[i], bookCover.getResourceId(i, -1), bookIsbn[i], bookPublisher[i], bookPage[i], bookSize[i])
            listNovel.add(novel)
        }
        return listNovel
    }

    private fun showRecyclerList(){
        rvNovel.layoutManager = LinearLayoutManager(this)
        val listNovelAdapter = ListNovelAdapter(list)
        rvNovel.adapter = listNovelAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}