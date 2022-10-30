package com.example.movierater_intermediate

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
                popup.inflate(R.menu.popup_menu)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

                    when (item!!.itemId) {
                        R.id.header1 -> {
                            val intent = Intent(this@MovieDetail, AddMovie::class.java)
                            startActivity(intent)
                        }

                    }

                    true
                })
                popup.show()
            }


        }


    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@MovieDetail, MainActivity::class.java)
        startActivity(intent)
        return true
    }
}