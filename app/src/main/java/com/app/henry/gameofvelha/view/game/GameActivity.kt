package com.app.henry.gameofvelha.view.game

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.app.henry.gameofvelha.R
import com.app.henry.gameofvelha.extentions.toast
import com.app.henry.gameofvelha.model.entity.Game
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity: AppCompatActivity(), View.OnClickListener{
    private var game: Game? = null
    private var currentPlayer: Int = 1
    private var ids: MutableList<TextView>? = null
    private val gameViewModel: GameViewModel by lazy {
        ViewModelProviders.of(this).get(GameViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        getGameExtra()
        setupPlayers()
        setupClicks()
        ids = mutableListOf(a11,a12,a13,a21,a22,a23,a31,a32,a33)

        gameViewModel.matrix()!!.observe(this, Observer {
            var position = 0
            for (line in 0..it!!.count()-1){
                for(col in it[line]){
                    if(col != 9){
                        if(col == 1){
                           ids!![position].text = game!!.playerOneSymbol
                       }else{
                           ids!![position].text = game!!.playerTwoSymbol
                       }
                    }
                    position++
                }
            }
        })

    }



    private fun getGameExtra(){
        with(intent.extras){
            if(this != null) game = this.get("game") as Game
        }
    }
    private fun mark(position: Pair<Int, Int>, id: Int){
        gameViewModel.mark(currentPlayer, position)
        val v = findViewById<TextView>(id)
        if(currentPlayer == 1){
            v.text = game!!.playerOneSymbol
            currentPlayer = 2
        }else{
            v.text = game!!.playerTwoSymbol
            currentPlayer = 1
        }
    }

    private fun setupPlayers(){
        playerOneName.text = game!!.playerOne
        playerTwoName.text = game!!.playerTwo
        if(game!!.playerOneSymbol == "X"){
            //toast("${game!!.playerOne} começa o jogo")
        }else{
            //toast("${game!!.playerTwo} começa o jogo")
        }
    }
    private fun setupClicks(){
        a11.setOnClickListener(this)
        a12.setOnClickListener(this)
        a13.setOnClickListener(this)
        a21.setOnClickListener(this)
        a22.setOnClickListener(this)
        a23.setOnClickListener(this)
        a31.setOnClickListener(this)
        a32.setOnClickListener(this)
        a33.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        with(v!!) {
            val position = this.toString().split("id/")[1]
            mark(Pair(position[1].toString().toInt() - 1, position[2].toString().toInt() - 1), v.id)
        }
    }
}
