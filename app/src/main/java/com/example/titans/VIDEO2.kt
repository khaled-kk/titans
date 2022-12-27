package com.example.titans

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_video1.*


class VIDEO2: AppCompatActivity() {

    private var playbackPosition = 0
    //private val realtimeUrl = "http://techslides.com/demos/sample-videos/small.webm"
    //private val realtimeUrl = "rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mp4"
    private lateinit var mediaController: MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video2)
        mediaController = MediaController(this)

        videoView.setOnPreparedListener {
            mediaController.setAnchorView(videoContainer)
            videoView.setMediaController(mediaController)
            videoView.seekTo(playbackPosition)
            videoView.start()
        }

        videoView.setOnInfoListener { player, what, extras ->
            if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
                progressBar.visibility = View.INVISIBLE
            true
        }
    }

    override fun onStart() {
        super.onStart()

        //val uri = Uri.parse(realtimeUrl)
        //videoView.setVideoURI(uri)
        progressBar.visibility = View.VISIBLE
        videoView!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.video2))



    }

    override fun onPause() {
        super.onPause()
        videoView.pause()
        playbackPosition = videoView.currentPosition
    }

    override fun onStop() {
        videoView.stopPlayback()

        super.onStop()

    }
}