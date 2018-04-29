package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.toast
import kotlinx.android.synthetic.main.activity_player_two.*

class PlayerTwoActivity: AppCompatActivity(){
    var playerOne: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_two)
        nextPlayerTwoButton.setOnClickListener{ changeToAdjust() }
        getPlayerOneExtra()
    }

    private fun changeToAdjust(){
        namePlayerTwoEditText.text.toString().let {
            if(!it.isEmpty()){
                val playerTwoIntent = Intent(this@PlayerTwoActivity, AdjustActivity::class.java)
                playerTwoIntent.putExtra("playerOne",  playerOne)
                playerTwoIntent.putExtra("playerTwo",  it)
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
                playerOne = this.get("playerOne") as String
            }
        }
    }
}
