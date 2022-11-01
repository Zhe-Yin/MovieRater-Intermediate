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
import com.example.movierater_intermediate.Movie
import com.example.movierater_intermediate.databinding.ActivityEditMovieBinding

class EditMovie : AppCompatActivity() {
    private lateinit var binding: ActivityEditMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditMovieBinding.inflate(layoutInflater)
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

            var m = Movie()

            name.setText(m.title)
            description.setText(m.desc)
            date.setText(m.date)
            val language_grp = findViewById(R.id.group_language) as RadioGroup
            val language_button = language_grp.checkedRadioButtonId
            if(m.language == language_button.toString())
            {
                language_grp.checkedRadioButtonId
            }
            if (m.below13 == true){
                below13.isChecked = true
            }
            if (m.language_used == true){
                languageUsed.isChecked == true
            }
            if(m.violence == false){
                violence.isChecked == false
            }


            below13.setOnClickListener{
                setvisibility()
            }



        }


    }
    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this@EditMovie,MovieDetail::class.java)
        startActivity(intent)
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.editmovie, menu)
        R.menu.editmovie
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.save -> {
            save()
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
            val intent = Intent(this@EditMovie, MovieDetail::class.java)
            startActivity(intent)
        }
    }
    private  fun setvisibility() {
        binding.apply {
            val linear: LinearLayout = findViewById(R.id.layout_reasons)
            if(below13.isChecked){
                linear.visibility = View.VISIBLE
            }else{
                linear.visibility = View.INVISIBLE
            }
        }
    }

    private fun save(){
        binding.apply {
            val intent = Intent(this@EditMovie,MovieDetail::class.java)
            val language_grp:RadioGroup = findViewById(R.id.group_language)
            val language_button = language_grp.checkedRadioButtonId
            val language = findViewById(language_button) as RadioButton

            intent.putExtra("title",name.text.toString())
            intent.putExtra("overview",description.text.toString())
            intent.putExtra("language",language.text.toString())
            intent.putExtra("date",date.text.toString())
            intent.putExtra("below13",below13.isChecked.toString())
            intent.putExtra("violence",violence.isChecked.toString())
            intent.putExtra("languageused",languageUsed.isChecked.toString())

            startActivity(intent)
        }
    }
}