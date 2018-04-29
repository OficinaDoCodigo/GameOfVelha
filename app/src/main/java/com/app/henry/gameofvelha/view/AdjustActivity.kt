package com.app.henry.gameofvelha.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.model.entity.Game
import kotlinx.android.synthetic.main.activity_adjust.*
import java.util.*

class AdjustActivity: AppCompatActivity(){
    private var game: Game? = null
    private var playerOne: String? = null
    private var playerTwo: String? = null
    private var playerOneSymbol: String? = null
    private var playerTwoSymbol: String? = null
    private var timeToPlay: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjust)
        getPlayersExtra()
        displayPlayers()
        randomSymbols()
        startButton.setOnClickListener{ startGame() }
    }

    private fun startGame(){
        val radioId = radioLimitTime.checkedRadioButtonId
        when(radioId){
            R.id.oneMinRadio -> timeToPlay = 60
            R.id.thirtySecRadio -> timeToPlay = 30
            R.id.fifteenSecRadio -> timeToPlay = 15
            R.id.fiveSecRadio -> timeToPlay = 5
        }
        val gameSetup = Intent(this@AdjustActivity, GameActivity::class.java)
        game!!.playerOneSymbol = playerOneSymbol
        game!!.playerTwoSymbol = playerTwoSymbol
        game!!.timeToPlay = timeToPlay
        gameSetup.putExtra("game", game)
        startActivity(gameSetup)
        finish()
        //TODO("Implement some animation here...")
    }
    private fun getPlayersExtra(){
        with(intent.extras){
            if(this != null){
                game = this.get("game") as Game
            }
        }
    }
    private fun displayPlayers(){
        namePlayerOneTextView.text = playerOne
        namePlayerTwoTextView.text = playerTwo
    }
    private fun randomSymbols(){
        val rand = Random().nextInt(2)
        if(rand == 0){
            playerOneSymbol = "X"
            playerTwoSymbol = "O"
            symbolPlayerOneTextView.text = playerOneSymbol
            symbolPlayerTwoTextView.text = playerTwoSymbol
        }else{
            playerOneSymbol = "X"
            playerTwoSymbol = "O"
            symbolPlayerOneTextView.text = playerOneSymbol
            symbolPlayerTwoTextView.text = playerTwoSymbol
        }
    }
}
