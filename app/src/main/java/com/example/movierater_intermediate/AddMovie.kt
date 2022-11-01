package com.example.movierater_intermediate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.movierater_intermediate.databinding.ActivityAddMovieBinding
import com.example.movierater_intermediate.Movie

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

            below13.setOnClickListener{
                setvisibility()
            }

        }

    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@AddMovie,MainActivity::class.java)
        startActivity(intent)
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.addmovie, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.clear -> {
            clearall()
            true
        }
        R.id.addmovie ->{
            addmovie()
            true
        }
        else -> super.onOptionsItemSelected(item)


    }


    private fun clearall(){
        binding.apply {
            name.text.clear()
            description.text.clear()
            date.text.clear()
            below13.isChecked = false
            languageused.isChecked = false
            violence.isChecked = false
            setvisibility()

        }
    }
    private fun addmovie(){
        binding.apply {
            val intent = Intent(this@AddMovie,MovieDetail::class.java)
            val language_grp:RadioGroup = findViewById(R.id.group_language)
            val language_button = language_grp.checkedRadioButtonId
            val language = findViewById(language_button) as RadioButton

            intent.putExtra("title",name.text.toString())
            intent.putExtra("overview",description.text.toString())
            intent.putExtra("language",language.text.toString())
            intent.putExtra("date",date.text.toString())
            intent.putExtra("below13",below13.isChecked.toString())
            intent.putExtra("violence",violence.isChecked.toString())
            intent.putExtra("languageused",languageused.isChecked.toString())

            startActivity(intent)

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
