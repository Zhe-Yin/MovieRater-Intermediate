package com.example.movierater_intermediate

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.ContextMenu.ContextMenuInfo
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
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

            // Long press for Review
            registerForContextMenu(reviews);

            // Populate textview with Info
            insertInfo()

        }


    }
    fun insertInfo(){
       binding.apply{
           // Info retrieve from EditMovie / AddMovie after intent
           val intent = intent
           title.text = intent.getStringExtra("title")
           overview.text = intent.getStringExtra("overview")
           language.text = intent.getStringExtra("language")
           date.text = intent.getStringExtra("date")
           below13.text = intent.getStringExtra("below13")
           println(intent.getStringExtra("below13"))
           if(below13.text == "true"){
               below13.setText("No")
               if (intent.getStringExtra("languageused") == "true" && intent.getStringExtra("violence") == "true" ) {
                   reason.setText("(Violence & Vulgar)")
                   reason.visibility = View.VISIBLE
               }
               if(intent.getStringExtra("languageused") == "true"){
                   reason.setText("(Vulgar)")
                   reason.visibility = View.VISIBLE
               }
               if(intent.getStringExtra("violence") == "true"){
                   reason.setText("(Violence)")
                   reason.visibility = View.VISIBLE
               }
           }else{
               below13.setText("Yes")
           }

           if(intent.getStringExtra("check") != "1"){
               reviews.text = intent.getStringExtra("review")
               rating.rating = intent.getStringExtra("rating")!!.toFloat()
           }
       }
    }

    // Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.moviedetail, menu)
        R.menu.moviedetail
        return true
    }

    // Items in Menu select listener
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.edit -> {
            val intent = Intent(this@MovieDetail, EditMovie::class.java)
            startActivity(intent)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    // Navigate to Main Page
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@MovieDetail, MainActivity::class.java)

        startActivity(intent)
        return true
    }

    // Context Menu
    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.add(0, v.id, 0, "Add Review")

    }

    // Context menu item select listener
    override fun onContextItemSelected(item: MenuItem): Boolean {
        if(item.title == "Add Review"){

            binding.apply {

                val intent1 = Intent(this@MovieDetail, Rating::class.java)
                val intent2 = intent

                intent1.putExtra("title",title.text.toString())
                intent1.putExtra("overview",overview.text.toString())
                intent1.putExtra("language",language.text.toString())
                intent1.putExtra("date",date.text.toString())
                intent1.putExtra("below13",intent2.getStringExtra("below13"))
                intent1.putExtra("violence",intent2.getStringExtra("violence"))
                intent1.putExtra("languageused",intent2.getStringExtra("languageused"))
                println(intent2.getStringExtra("below13"))

                startActivity(intent1)
            }
        }

        return true
    }




}






