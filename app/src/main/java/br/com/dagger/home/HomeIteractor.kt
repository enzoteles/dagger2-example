package br.com.dagger.home

import android.content.Context
import android.util.Log
import android.widget.Toast

class HomeIteractor(var presenter: HomeMVP.Presenter): HomeMVP.Iteractor{

    override fun teste(baseContext: Context?) {
        Log.i("dagger>>", "homeiteractor")
    }
}