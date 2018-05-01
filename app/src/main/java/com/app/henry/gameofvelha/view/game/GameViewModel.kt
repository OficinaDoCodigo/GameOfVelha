package com.app.henry.gameofvelha.view.game

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

class GameViewModel: ViewModel() {

    private var matrix = MutableLiveData<MutableList<MutableList<Int>>>().apply {
        value = mutableListOf(
                mutableListOf(9,9,9),
                mutableListOf(9,9,9),
                mutableListOf(9,9,9))
    }
    fun mark(player: Int, position: Pair<Int, Int>){
        for (line in 0..matrix.value!!.count()-1){
            for(col in matrix.value!![line]){
                matrix.value!!.get(position.first)[position.second] = player
            }
        }

    }

    fun matrix(): MutableLiveData<MutableList<MutableList<Int>>>? = matrix
}