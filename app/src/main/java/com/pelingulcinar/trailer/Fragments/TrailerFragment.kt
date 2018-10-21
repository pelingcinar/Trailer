package com.pelingulcinar.trailer.Fragments

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import at.huber.youtubeExtractor.VideoMeta
import at.huber.youtubeExtractor.YouTubeExtractor
import at.huber.youtubeExtractor.YtFile
import com.pelingulcinar.trailer.Model.MoviesDTO
import com.pelingulcinar.trailer.R
import kotlinx.android.synthetic.main.fragment_trailer.*


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
        val view = inflater.inflate(R.layout.fragment_trailer, container, false)

        return view
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //media controller

        val mediaController = MediaController(context)
        mediaController.visibility = View.GONE

        mediaController.setAnchorView(videoView)
        videoView.setZOrderMediaOverlay(true)

        // youtube link

        object : YouTubeExtractor(context!!) {
            override fun onExtractionComplete(ytFiles: SparseArray<YtFile>?, vMeta: VideoMeta?) {
                if (ytFiles != null) {
                    var itag = 18
                    var downloadUrl = ytFiles.get(itag).url
                    val uri = Uri.parse(downloadUrl)
                    videoView.setMediaController(mediaController)
                    videoView.setVideoURI(uri)
                    videoView.requestFocus()
                }
            }
        }.extract(movies.movieURL, true, true)


        txtMovieName.text = movies.movieTitle

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        if (videoView != null) {
            if (isVisibleToUser) {
                videoView.start()

            } else {
                videoView.pause()
            }
        }
    }



    // Pause the video

    override fun onPause() {
        super.onPause()

        videoView.pause()
    }

    // Stop the video

    override fun onStop() {
        videoView.stopPlayback()

        super.onStop()
    }

    // Start the video onResume

    override fun onResume() {
        super.onResume()
        if (userVisibleHint)
            videoView.start()

    }



}



