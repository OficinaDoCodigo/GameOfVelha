package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.toast
import com.app.henry.gameofvelha.model.entity.Game
import kotlinx.android.synthetic.main.activity_player_one.*

class PlayerOneActivity: AppCompatActivity() {
    private var game = Game()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)
        nextPlayerOneButton.setOnClickListener{ changeToPlayerTwo() }
    }

    private fun changeToPlayerTwo(){
        namePlayerOneEditText.text.toString().let {
            if(!it.isEmpty()){
                val playerOneIntent = Intent(this@PlayerOneActivity, PlayerTwoActivity::class.java)
                game.playerOne = it
                playerOneIntent.putExtra("game", game)
                startActivity(playerOneIntent)
                //TODO("Implement some animation here...")
            }else{
                toast("Digite seu nome...")
            }
        }
    }
}
