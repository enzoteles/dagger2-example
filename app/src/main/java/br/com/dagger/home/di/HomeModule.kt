package br.com.dagger.home.di

import android.icu.text.IDNA
import br.com.dagger.Constant
import br.com.dagger.home.HomeIteractor
import br.com.dagger.home.HomeMVP
import br.com.dagger.home.HomePresenter
import dagger.Module
import dagger.Provides

@Module
class HomeModule(var view: HomeMVP.View){

    @Provides
    fun proverHomePresenter(): HomeMVP.Presenter {
        return HomePresenter(view)
    }

    @Provides
    fun proverHomeIteractor(): HomeMVP.Iteractor{
        return HomeIteractor(HomePresenter(view))
    }
}