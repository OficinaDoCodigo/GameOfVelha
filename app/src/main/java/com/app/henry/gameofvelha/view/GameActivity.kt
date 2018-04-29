package com.app.henry.gameofvelha.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.model.entity.Game
import java.util.ArrayList

class GameActivity: AppCompatActivity() {
    private var playerOne: String? = null
    private var playerTwo: String? = null
    private var playerOneSymbol: String? = null
    private var playerTwoSymbol: String? = null
    private var timeToPlay: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        getGameSetup()
    }

    private fun getGameSetup(){
        with(intent.extras){
            if(this != null){
                val game = this.get("game") as Game
                playerOne       = game.playerOne
                playerTwo       = game.playerTwo
                playerOneSymbol = game.playerOneSymbol
                playerTwoSymbol = game.playerTwoSymbol
                timeToPlay      = game.timeToPlay
            }
        }
    }
}
