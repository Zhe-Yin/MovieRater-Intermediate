package com.example.movierater_intermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
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
//                val dialogBuilder = AlertDialog.Builder(this@MovieDetail)
//                dialogBuilder.setMessage("Add Review")
//                dialogBuilder.setPositiveButton("Done",
//                    DialogInterface.OnClickListener { dialog, whichButton -> })
//                val b = dialogBuilder.create()
//                b.show()
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


            val profileName=intent.getStringExtra("Username")


        }


    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@MovieDetail, MainActivity::class.java)
        startActivity(intent)
        return true
    }
}