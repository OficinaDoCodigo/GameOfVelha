package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.henry.gameofvelha.R
import kotlinx.android.synthetic.main.activity_player_one.*

class PlayerOneActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)
        nextPlayerOneButton.setOnClickListener{ changeToPlayerTwo() }
    }

    private fun changeToPlayerTwo(){
        startActivity(Intent(this@PlayerOneActivity, PlayerTwoActivity::class.java))
        finish()
        //TODO("Implement some animation here...")
    }
}
