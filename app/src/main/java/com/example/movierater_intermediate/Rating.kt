package com.example.movierater_intermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.movierater_intermediate.databinding.ActivityRatingBinding

class Rating : AppCompatActivity() {
    private lateinit var binding: ActivityRatingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRatingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply{
            //actionbar
            val actionbar = supportActionBar
            //set actionbar title
            actionbar!!.title = "MovieRater"
            //set back button
            actionbar.setDisplayHomeAsUpEnabled(true)

        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.submitreview, menu)
        R.menu.submitreview
        return true
    }

    // Items in Menu select listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.addreview -> {
            binding.apply {
                val intent1 = Intent(this@Rating,MovieDetail::class.java)
                val intent2 = intent

                intent1.putExtra("title",intent2.getStringExtra("title"))
                intent1.putExtra("overview",intent2.getStringExtra("overview"))
                intent1.putExtra("language",intent2.getStringExtra("language"))
                intent1.putExtra("date",intent2.getStringExtra("date"))
                intent1.putExtra("below13",intent2.getStringExtra("below"))
                intent1.putExtra("violence",intent2.getStringExtra("violence"))
                intent1.putExtra("languageused",intent2.getStringExtra("langageused"))

                intent1.putExtra("rating",rating.rating.toString())
                intent1.putExtra("review",review.text.toString())

                intent1.putExtra("check","0")

                startActivity(intent1)
            }

            true
        }
        else -> super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@Rating,MovieDetail::class.java)
        val intent2 = intent

        intent.putExtra("title",intent2.getStringExtra("title"))
        intent.putExtra("overview",intent2.getStringExtra("overview"))
        intent.putExtra("language",intent2.getStringExtra("language"))
        intent.putExtra("date",intent2.getStringExtra("date"))
        intent.putExtra("below13",intent2.getStringExtra("below"))
        intent.putExtra("violence",intent2.getStringExtra("violence"))
        intent.putExtra("languageused",intent2.getStringExtra("langageused"))

        intent.putExtra("check","1")

        startActivity(intent)
        return true
    }
}

