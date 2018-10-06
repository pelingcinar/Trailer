package com.pelingulcinar.trailer.Adapter

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.pelingulcinar.trailer.Fragments.TrailerFragment
import com.pelingulcinar.trailer.Model.MoviesDTO

class MainViewPagerAdapter (fragmentManager: FragmentManager, private val movies : ArrayList<MoviesDTO>):
        FragmentStatePagerAdapter(fragmentManager){


    override fun getItem(position: Int): TrailerFragment {

        return TrailerFragment.newInstance(movies[position])

    }


   // override fun getItem(position: Int): TrailerFragment = movies[position]

    override fun getCount(): Int {
        return movies.size

    }
}