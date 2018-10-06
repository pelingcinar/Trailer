package com.pelingulcinar.trailer.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pelingulcinar.trailer.Model.MoviesDTO
import com.pelingulcinar.trailer.R


class TrailerFragment : Fragment() {

    private val movies by lazy { arguments?.getSerializable("movies") as MoviesDTO }

    companion object {
        fun newInstance(movies: MoviesDTO): TrailerFragment {
            val trailerFragment = TrailerFragment()
            val bundle = Bundle()
            bundle.putSerializable("movies", movies)
            trailerFragment.arguments = bundle
            return trailerFragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_trailer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       /* txtMovieName.text = movie.movieName

        youTubePlayerSupportFragment = YouTubePlayerSupportFragment.newInstance()
        youTubePlayerSupportFragment.initialize(Constant.YOUTUBE_API_KEY, this)

        val transaction = fragmentManager?.beginTransaction()!!
        transaction.replace(R.id.youtube_holder, youTubePlayerSupportFragment as Fragment).commit()*/


    }


}



