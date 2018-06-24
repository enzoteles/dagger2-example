package br.com.dagger.home

import android.content.Context

interface HomeMVP {
    interface View
    interface Presenter {
        fun teste(baseContext: Context?)
    }
    interface Iteractor {
        fun teste(baseContext: Context?)
    }
}
