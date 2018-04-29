package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.toast
import kotlinx.android.synthetic.main.activity_player_one.*

class PlayerOneActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)
        nextPlayerOneButton.setOnClickListener{ changeToPlayerTwo() }
    }

    private fun changeToPlayerTwo(){
        namePlayerOneEditText.text.toString().let {
            if(!it.isEmpty()){
                val playerOneIntent = Intent(this@PlayerOneActivity, PlayerTwoActivity::class.java)
                playerOneIntent.putExtra("playerOne", it)
                startActivity(playerOneIntent)
                //TODO("Implement some animation here...")
            }else{
                toast("Digite seu nome...")
            }
        }
    }
}
