package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import kotlinx.android.synthetic.main.activity_player_two.*

class PlayerTwoActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_two)
        nextPlayerTwoButton.setOnClickListener{ changeToAdjust() }
    }

    private fun changeToAdjust(){
        startActivity(Intent(this@PlayerTwoActivity, AdjustActivity::class.java))
        finish()
        //TODO("Implement some animation here...")
    }
}
