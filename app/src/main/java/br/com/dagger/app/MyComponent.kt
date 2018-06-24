package br.com.dagger.app

import br.com.dagger.MainActivity
import br.com.dagger.content.ContentFragment
import br.com.dagger.content.ContentPresenter
import br.com.dagger.content.di.ContentModule
import br.com.dagger.home.di.HomeModule
import br.com.dagger.home.di.MsgModule
import dagger.Component


interface MyComponent {
    /**
     * ======================================================
     *              Content Screen
     * ======================================================
     * */
    @Component(modules = arrayOf(ContentModule::class, AppModule::class))
    interface ContentComponent{
        fun inject(view: ContentFragment)
        fun inject(presenter: ContentPresenter)
    }

    /**
     * ======================================================
     *              Home Screen
     * ======================================================
     * */
    @Component(modules = arrayOf(HomeModule::class, AppModule::class, MsgModule::class))
    interface HomeComponent{
        fun inject(view: br.com.dagger.home.HomeFragment)
        fun inject(presenter: br.com.dagger.home.HomePresenter)
    }

}