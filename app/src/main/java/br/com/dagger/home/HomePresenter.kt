package br.com.dagger.home

import android.app.Activity
import android.content.Context
import android.util.Log
import br.com.dagger.app.DaggerMyComponent_HomeComponent
import br.com.dagger.home.di.HomeModule
import br.com.dagger.home.di.MsgModule
import javax.inject.Inject

class HomePresenter(var view: HomeMVP.View): HomeMVP.Presenter{

    @Inject
    lateinit var iteractor:HomeMVP.Iteractor

    override fun teste(baseContext: Context?, activity: Activity) {
        Log.i("dagger>>", "homepresenter")

        var homeComponent = DaggerMyComponent_HomeComponent.builder()
                .homeModule(HomeModule(view))
                .msgModule(MsgModule(activity))
                .build()
        homeComponent!!.inject(this)
        iteractor.teste(baseContext)
    }

}