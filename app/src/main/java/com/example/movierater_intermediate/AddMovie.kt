package com.example.movierater_intermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import com.example.movierater_intermediate.databinding.ActivityAddMovieBinding

class AddMovie : AppCompatActivity() {
    private lateinit var binding: ActivityAddMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.apply{
            //actionbar
            val actionbar = supportActionBar
            //set actionbar title
            actionbar!!.title = "MovieRater"
            //set back button
            actionbar.setDisplayHomeAsUpEnabled(true)
            setvisibility()

            class Movie{
                var title = "Venom"
                var desc = "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life"
                var lang = "English"
                var date = "03-10-2018"
                var suitable = "No"

            }


            var m = Movie()

            name.setText(m.title)
            description.setText(m.desc)
//            language.setText(m.lang)
            date.setText(m.date)
//            below13.setText(m.suitable)

            below13.setOnClickListener{
                setvisibility()
            }

        }


    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@AddMovie,MovieDetail::class.java)
        startActivity(intent)
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.addmovie_action_buttons, menu)
        R.menu.addmovie_action_buttons
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.clear -> {
            clearall()
            true
        }

        R.id.cancel -> {
            cancel()
            true
        }
        else -> super.onOptionsItemSelected(item)


    }
    private fun cancel(){
        binding.apply{
            val intent = Intent(this@AddMovie, MovieDetail::class.java)
            startActivity(intent)
        }
    }

    private fun clearall(){
        binding.apply {
            name.text.clear()
            description.text.clear()
            date.text.clear()
            below13.isChecked = false
            setvisibility()

        }
        }
    private  fun setvisibility() {
        binding.apply {
            val linear:LinearLayout = findViewById(R.id.layout_reasons)
            if(below13.isChecked){
                linear.visibility = View.VISIBLE
            }else{
                linear.visibility = View.INVISIBLE
            }
        }
    }

    }
