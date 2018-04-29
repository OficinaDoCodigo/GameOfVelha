package com.app.henry.gameofvelha.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.toast
import kotlinx.coroutines.experimental.launch
import com.app.henry.gameofvelha.extentions.supportLollypop

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        /*window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        supportLollypop {
            window.statusBarColor = Color.WHITE
        }*/

        launch {
            Thread.sleep(3000)
            runOnUiThread {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}

