package com.example.movierater_intermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

            reviews.setOnClickListener{
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
//            var m = Movie()
//
//            title.setText(m.title)
//            overview.setText(m.desc)
//            date.setText(m.date)
//            val language_grp = findViewById(R.id.group_language) as RadioGroup
//            val language_button = language_grp.checkedRadioButtonId
//            if(m.language == language_button.toString())
//            {
//                language_grp.checkedRadioButtonId
//            }
//            if (m.below13 == true){
//                below13.isChecked = true
//            }
//            if (m.language_used == true){
//                languageUsed.isChecked == true
//            }
//            if(m.violence == true){
//                violence.isChecked == true
//            }


        }


    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.moviedetail, menu)
        R.menu.moviedetail
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@MovieDetail, MainActivity::class.java)
        startActivity(intent)
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

}