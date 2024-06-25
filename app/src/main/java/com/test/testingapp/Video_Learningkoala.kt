package com.test.testingapp

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.test.testingapp.databinding.ActivityVideokolLearningBinding

class Video_Learningkoala : AppCompatActivity() {

    private lateinit var binding: ActivityVideokolLearningBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videokol_learning)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding = ActivityVideokolLearningBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = findViewById<VideoView>(R.id.koala_video)
        val videoPackage = "android.resource://$packageName/${R.raw.koalavideo}"
        val uri = Uri.parse(videoPackage)
        videoView.setVideoURI(uri)

        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        binding.backArrow.setOnClickListener {
            onBackPressed()
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
    /*private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var toolbar: MaterialToolbar
    private lateinit var appbar: ConstraintLayout
    private lateinit var fullscreenContainer: FrameLayout
    private var customView: View? = null
    private var customViewCallback: WebChromeClient.CustomViewCallback? = null
    private var ogOrientation = 0
    private var ogSystemUiVisibility = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_learning)

        toolbar = findViewById(R.id.back_arrow)
        webView = findViewById(R.id.vidLearn_webView)
        progressBar = findViewById(R.id.progressBar)
        appbar = findViewById(R.id.appBar)
        fullscreenContainer = findViewById(R.id.fullscreen_container)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = chromeView()

        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener { onBackPressed() }

        val video_title = intent.getStringExtra("Title").toString()
        var link = intent.getStringExtra("Link").toString()
        toolbar.setTitle(video_title)
        link = link.replace("width=\"560\"", "width=\"100%\"").replace("height=\"315\"", "height=\"100%\"")
        webView.loadData(link, "text/html","utf-8")

        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    inner class chromeView : WebChromeClient() {
        override fun getDefaultVideoPoster(): Bitmap? {
            return if (customView == null) null else BitmapFactory.decodeResource(applicationContext.resources, R.drawable.ondemand_video)
        }

        override fun onHideCustomView() {
            fullscreenContainer.removeView(customView)
            customView = null
            window.decorView.systemUiVisibility = ogSystemUiVisibility
            requestedOrientation = ogOrientation
            customViewCallback?.onCustomViewHidden()
            customViewCallback = null
            fullscreenContainer.visibility = View.GONE

            //back to og
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            appbar.visibility = View.VISIBLE
            toolbar.visibility = View.VISIBLE
            fullScrennVideo()
        }

        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
            if (customView != null) {
                onHideCustomView()
                return
            }

            customView = view
            ogSystemUiVisibility = window.decorView.systemUiVisibility
            ogOrientation = requestedOrientation
            customViewCallback = callback
            fullscreenContainer.visibility = View.VISIBLE
            fullscreenContainer.addView(customView, FrameLayout.LayoutParams(-1, -1))
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_FULLSCREEN

            //hide
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            appbar.visibility = View.GONE
            toolbar.visibility = View.GONE
            fullScrennVideo()
        }

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            progressBar.progress = newProgress
            if(newProgress != 100) {
                progressBar.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.GONE
            }
        }
    }

    @JavascriptInterface
    fun fullScrennVideo() {
        runOnUiThread{
            val decor = window.decorView
            decor.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        }
    }

    @JavascriptInterface
    fun exitFullScreenVideo() {
        runOnUiThread {
            val decor = window.decorView
            decor.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        }
    }*/
}