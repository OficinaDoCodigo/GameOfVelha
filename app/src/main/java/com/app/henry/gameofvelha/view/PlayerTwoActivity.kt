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
import kotlinx.android.synthetic.main.activity_player_two.*

class PlayerTwoActivity: AppCompatActivity(){
    private var game: Game? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_two)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        supportLollypop {
            window.statusBarColor = Color.TRANSPARENT
        }
        getExtraGame()
        nextPlayerTwoButton.setOnClickListener{ changeToAdjust() }
    }

    private fun changeToAdjust(){
        namePlayerTwoEditText.text.toString().let {
            if(!it.isEmpty()){
                val playerTwoIntent = Intent(this@PlayerTwoActivity, AdjustActivity::class.java)
                game!!.playerTwo = it
                playerTwoIntent.putExtra("game",  game)
                startActivity(playerTwoIntent)
                //TODO("Implement some animation here...")
            }else{
                toast("Digite seu nome...")
            }
        }
    }
    private fun getExtraGame(){
        with(intent.extras){
            if(this != null){
                game = this.get("game") as Game
            }
        }
    }
}
