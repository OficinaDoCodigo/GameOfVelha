package com.app.henry.gameofvelha.view

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.supportLollypop
import com.app.henry.gameofvelha.model.entity.Game
import com.app.henry.gameofvelha.view.game.GameActivity
import kotlinx.android.synthetic.main.activity_adjust.*
import java.util.*

class AdjustActivity: AppCompatActivity(){
    private var game: Game? = null
    private var playerOneSymbol: String? = null
    private var playerTwoSymbol: String? = null
    private var timeToPlay: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjust)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        supportLollypop {
            window.statusBarColor = Color.TRANSPARENT
        }
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
        game!!.playerOneSymbol = playerOneSymbol as String
        game!!.playerTwoSymbol = playerTwoSymbol as String
        game!!.timeToPlay = timeToPlay as Int
        gameSetup.putExtra("game", game)
        startActivity(gameSetup)
        finish()
        //TODO("Implement some animation here...")
    }
    private fun getPlayersExtra(){
        with(intent.extras){
            if(this != null) game = this.get("game") as Game
        }
    }
    private fun displayPlayers(){
        namePlayerOneTextView.text = game!!.playerOne
        namePlayerTwoTextView.text = game!!.playerTwo
    }
    private fun randomSymbols(){
        val rand = Random().nextInt(2)
        if(rand == 0){
            playerOneSymbol = "X"
            playerTwoSymbol = "O"
        }else{
            playerOneSymbol = "O"
            playerTwoSymbol = "X"
        }
        symbolPlayerOneTextView.text = playerOneSymbol
        symbolPlayerTwoTextView.text = playerTwoSymbol
    }
}
