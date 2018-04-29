package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import kotlinx.android.synthetic.main.activity_adjust.*

class AdjustActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjust)
        startButton.setOnClickListener{ changeToLoadGame() }
    }

    private fun changeToLoadGame(){
        startActivity(Intent(this@AdjustActivity, LoadGameActivity::class.java))
        finish()
        //TODO("Implement some animation here...")
    }

}
