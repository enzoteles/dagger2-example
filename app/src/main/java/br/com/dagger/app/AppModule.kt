package br.com.dagger.app

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(var application: Application){

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Application = this.application

}