package br.com.dagger.content.di

import br.com.dagger.content.ContentFragment
import br.com.dagger.content.ContentIteractor
import br.com.dagger.content.ContentMVP
import br.com.dagger.content.ContentPresenter
import dagger.Module
import dagger.Provides

@Module
class ContentModule(var view: ContentMVP.View){

    @Provides
    fun proverContentPresenter(): ContentMVP.Presenter{
        return ContentPresenter(view)
    }

    @Provides
    fun proverContentIteractor(): ContentMVP.Iteractor{
        return ContentIteractor(ContentPresenter(view))
    }



}