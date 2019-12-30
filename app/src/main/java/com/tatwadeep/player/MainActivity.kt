package com.tatwadeep.player

import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import com.tatwadeep.phonicplayer.handler.PlayerListObserver
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PlayerListObserver.instance?.registerLifecycle(lifecycle)
        a_main_audio_player1.setDownloadDirectory(getString(R.string.app_name))
        a_main_audio_player1.setAudioTarget("http://virtue-services.gmrwebteam.com/uploads/answer-audio/1576560057825.mp3","1576560057825.mp3")
        a_main_audio_player3.setAudioTarget("https://p.scdn.co/mp3-preview/a74efdaa12f708673a14fdf67bfb6ec365d8ebf0?cid=96fac036ea6347f49035fb49be1e1d14")
    }
}
