package a201457F.assignment_1.movierater_intermediate

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.movierater_intermediate.R
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

            name.text = name.text.toString() + intent.getStringExtra("title")

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

                val rating = rating.rating.toFloat()
                val review = review.text.toString()
                val intent = Intent()
                intent.putExtra("rating",rating)
                intent.putExtra("review",review)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }

            true
        }
        else -> super.onOptionsItemSelected(item)
    }
    override fun onSupportNavigateUp(): Boolean {
        val Myintent = Intent(this@Rating, MovieDetail::class.java)
        val intent2 = intent

        Myintent.putExtra("title",intent2.getStringExtra("title"))
        Myintent.putExtra("overview",intent2.getStringExtra("overview"))
        Myintent.putExtra("language",intent2.getStringExtra("language"))
        Myintent.putExtra("date",intent2.getStringExtra("date"))
        Myintent.putExtra("below13",intent2.getStringExtra("below"))
        Myintent.putExtra("violence",intent2.getStringExtra("violence"))
        Myintent.putExtra("languageused",intent2.getStringExtra("langageused"))

        Myintent.putExtra("check","1")

        startActivity(Myintent)
        return true
    }
}

