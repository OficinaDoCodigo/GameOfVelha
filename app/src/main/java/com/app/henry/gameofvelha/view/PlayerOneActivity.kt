package com.app.henry.gameofvelha.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.supportLollypop
import com.app.henry.gameofvelha.extentions.toast
import com.app.henry.gameofvelha.model.entity.Game
import kotlinx.android.synthetic.main.activity_player_one.*

class PlayerOneActivity: AppCompatActivity() {
    private var game = Game("","","","",0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_one)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        supportLollypop {
            window.statusBarColor = Color.TRANSPARENT
        }
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
