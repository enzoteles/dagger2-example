package br.com.dagger.app

import android.app.Application
import br.com.dagger.home.di.HomeModule

class MyApp: Application(){

    //lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()
        //createComponent()
    }

    /*protected open fun createComponent() {
        var component = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }*/
}