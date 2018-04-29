package com.app.henry.gameofvelha.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Game: Parcelable{
    var playerOne: String? = null
    var playerTwo: String? = null
    var playerOneSymbol: String? = null
    var playerTwoSymbol: String? = null
    var timeToPlay: Int? = null
}