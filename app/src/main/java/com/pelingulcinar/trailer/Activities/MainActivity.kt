package com.pelingulcinar.trailer.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.pelingulcinar.trailer.Adapter.MainViewPagerAdapter
import com.pelingulcinar.trailer.Model.MoviesDTO
import com.pelingulcinar.trailer.R


class MainActivity : AppCompatActivity() {

    //val movies = MovieHelper.getMoviesFromJson("movies.json", this)

    private lateinit var viewPager: ViewPager
    //private lateinit var pagerAdapter: MainViewPagerAdapter
    //val pagerAdapter by lazy { MainViewPagerAdapter(supportFragmentManager,loadFragment()) }
    //val fragmentAdapter by lazy { MainViewPagerAdapter(supportFragmentManager, loadFragment()) }
    val fragmentAdapter by lazy { MainViewPagerAdapter(supportFragmentManager, loadFragment()) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager_main)

       //pagerAdapter = MainViewPagerAdapter(supportFragmentManager, movies)
        //pagerAdapter = MainViewPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

    }

    companion object {
        private fun loadFragment(): ArrayList<MoviesDTO> {
            val movies = ArrayList<MoviesDTO>()
            movies.add(MoviesDTO("Fantastic Beats 2", "https://www.youtube.com/watch?v=5sEaYB4rLFQ"))
            movies.add(MoviesDTO("Venom", "https://www.youtube.com/watch?v=u9Mv98Gr5pY"))
            movies.add(MoviesDTO("Organize İşler 2", "https://www.youtube.com/watch?v=p3l7RS8tckE"))


            return movies
        }
    }
}
