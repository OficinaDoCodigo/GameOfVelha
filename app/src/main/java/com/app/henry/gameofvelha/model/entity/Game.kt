package com.app.henry.gameofvelha.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Game(var playerOne: String, var playerTwo: String,
           var playerOneSymbol: String, var playerTwoSymbol: String,
           var timeToPlay: Int): Parcelable