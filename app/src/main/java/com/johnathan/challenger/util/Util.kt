package com.johnathan.challenger.util

import android.content.Context
import android.util.Log
import android.widget.Toast

object Util {

    fun addLog(message: String, throwable: Throwable?) {
        Log.d(Constants.TAG.toString(), message, throwable)
    }

    fun showToast(context: Context, message: String){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}