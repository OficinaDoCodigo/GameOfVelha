package com.app.henry.gameofvelha.extentions

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.widget.Toast

fun Activity.toast(msg: String = "Toast!", time: Int = Toast.LENGTH_LONG){
    Toast.makeText(this, msg, time).show()
}

inline fun supportLollypop(code: () -> Unit){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        code()
    }
}
