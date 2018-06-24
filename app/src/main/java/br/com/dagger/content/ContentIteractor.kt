package br.com.dagger.content

import android.content.Context
import android.util.Log
import android.widget.Toast

class ContentIteractor(var presenter: ContentMVP.Presenter): ContentMVP.Iteractor{

    override fun teste(baseContext: Context) {
        Log.i("dagger>>", "contentiteractor")
        presenter.showHome()
    }
}