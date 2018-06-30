package br.com.dagger.home

import android.app.Activity
import android.content.Context

interface HomeMVP {
    interface View{
        fun setList()
    }
    interface Presenter {
        fun teste(baseContext: Context?, activity: Activity)
    }
    interface Iteractor {
        fun teste(baseContext: Context?)
    }
}
