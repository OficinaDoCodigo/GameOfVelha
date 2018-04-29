package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.toast
import com.app.henry.gameofvelha.model.entity.Game
import kotlinx.android.synthetic.main.activity_player_two.*

class PlayerTwoActivity: AppCompatActivity(){
    private var game: Game? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_two)
        getPlayerOneExtra()
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
    private fun getPlayerOneExtra(){
        with(intent.extras){
            if(this != null){
                 game = this.get("game") as Game
            }
        }
    }
}
