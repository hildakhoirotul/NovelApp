package com.example.hildasubmission

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailNovel : AppCompatActivity() {

    companion object{
        const val EXTRA_NOVEL = "key_hero"
    }

    var b: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_novel)

        val dataNovel = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_NOVEL, Novel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_NOVEL)
        }

        if (dataNovel != null){
            b = intent.extras
            val tvDetailName = findViewById<TextView>(R.id.novel_title)
            val tvDetailDescription = findViewById<TextView>(R.id.desc)
            val ivDetailPhoto = findViewById<ImageView>(R.id.novel_cover)
            val tvDetailIsbn = findViewById<TextView>(R.id.isbn)
            val tvDetailPublisher = findViewById<TextView>(R.id.publisher)
            val tvDetailPage = findViewById<TextView>(R.id.page)
            val tvDetailSize = findViewById<TextView>(R.id.size)

            tvDetailName.text = dataNovel.name
            tvDetailDescription.text = dataNovel.description
            ivDetailPhoto.setImageResource(dataNovel.photo)
            tvDetailIsbn.text = b?.getString("isbn")
            tvDetailPublisher.text = b?.getString("publisher")
            tvDetailPage.text = b?.getString("page")
            tvDetailSize.text = b?.getString("size")
        }

    }

}