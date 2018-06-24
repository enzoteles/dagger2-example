package br.com.dagger.content

import android.content.Context

interface ContentMVP {

    interface View {
        fun showHome()
    }

    interface Presenter {
        fun teste(context: Context)
        fun showHome()
        fun initView(context: Context?)
    }
    interface Iteractor {
        fun teste(baseContext: Context)
    }
}
