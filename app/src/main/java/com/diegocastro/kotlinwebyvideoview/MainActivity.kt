package com.diegocastro.kotlinwebyvideoview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myWebView:WebView=findViewById(R.id.webView)

        myWebView.loadUrl("https://www.bing.com")

        val btn_buscar:Button=findViewById(R.id.btn_buscar)
        val et_buscar:EditText=findViewById(R.id.et_buscar)

        btn_buscar.setOnClickListener{
            var cadena : String=et_buscar.text.toString()
            myWebView.loadUrl("https://www.bing.com/search?q=$cadena")

        }
        //fin web view

        //inicio video view (requiere crear carpeta de recursos raw)
        val myVideoView: VideoView=findViewById(R.id.myVideoView)
        val ruta:String="android.resource://"+packageName+"/"+R.raw.video1
        val videoUri:Uri=Uri.parse(ruta)
        myVideoView.setVideoURI(videoUri)

        //agregar los controles de video
        val mediaController= MediaController(this)
        myVideoView.setMediaController(mediaController)
        mediaController.setAnchorView(myVideoView)

        //video y web view

        //metodo para que comience el video
        myVideoView.setOnPreparedListener{
            myVideoView.start()
        }

        //metodo para que indique el fin del video
        myVideoView.setOnCompletionListener {
            Toast.makeText(this, "Video finalizado", Toast.LENGTH_SHORT).show()
        }

        //fin video view


    }
}