package com.app.henry.gameofvelha.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.supportLollypop
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        supportLollypop {
            window.statusBarColor = Color.TRANSPARENT
        }
        playButton.setOnClickListener { changeToPlayerOne() }
    }


    private fun changeToPlayerOne(){
        startActivity(Intent(this@MainActivity, PlayerOneActivity::class.java))
        //TODO("Implement some animation here...")
    }
}
