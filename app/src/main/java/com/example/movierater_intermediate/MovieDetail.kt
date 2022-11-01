package com.example.movierater_intermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.widget.PopupMenu
import com.example.movierater_intermediate.databinding.ActivityMovieDetailBinding

class MovieDetail : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply{
            //actionbar
            val actionbar = supportActionBar
            //set actionbar title
            actionbar!!.title = "MovieRater"
            //set back button
            actionbar.setDisplayHomeAsUpEnabled(true)

            reviews.setOnClickListener {
                val popup = PopupMenu(this@MovieDetail,reviews)
                popup.inflate(R.menu.addreview)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

                    when (item!!.itemId) {
                        R.id.addreview -> {
                            val intent = Intent(this@MovieDetail, Rating::class.java)
                            startActivity(intent)
                        }

                    }

                    true
                })
                popup.show()
            }

            val intent = intent
            title.text = intent.getStringExtra("title")
            overview.text = intent.getStringExtra("overview")
            language.text = intent.getStringExtra("language")
            date.text = intent.getStringExtra("date")
            below13.text = intent.getStringExtra("below13")
            languageused.text = intent.getStringExtra("languageused")
            violence.text = intent.getStringExtra("violence")
            if(below13.text == "true"){
                below13.setText("No")
                if (languageused.text == "true"){
                    languageused.setText("(Violence)")
                    language.visibility = View.VISIBLE
                }else{
                    languageused.text = ""
                }
                if(violence.text == "true"){
                    violence.setText("(Vulgar)")
                    violence.visibility = View.VISIBLE
                }else{
                    violence.text = ""

                }
            }else{
                below13.setText("Yes")
            }

        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.moviedetail, menu)
        R.menu.moviedetail
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.edit -> {
            val intent = Intent(this@MovieDetail, EditMovie::class.java)
            startActivity(intent)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@MovieDetail, MainActivity::class.java)
        startActivity(intent)
        return true
    }




}






