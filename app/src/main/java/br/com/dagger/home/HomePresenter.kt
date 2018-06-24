package br.com.dagger.home

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import br.com.dagger.app.AppModule
import br.com.dagger.app.DaggerMyComponent_HomeComponent
import br.com.dagger.home.di.HomeModule
import br.com.dagger.home.di.MsgModule
import javax.inject.Inject

class HomePresenter(var view: HomeMVP.View): HomeMVP.Presenter{

    @Inject
    lateinit var iteractor:HomeMVP.Iteractor

    override fun teste(baseContext: Context?) {
        Log.i("dagger>>", "homepresenter")

        var homeComponent = DaggerMyComponent_HomeComponent.builder()
                .homeModule(HomeModule(view))
                .msgModule(MsgModule(baseContext as Activity))
                .build()
        homeComponent!!.inject(this)
        iteractor.teste(baseContext)
    }

}