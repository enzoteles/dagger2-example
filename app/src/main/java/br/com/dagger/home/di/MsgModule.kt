package br.com.dagger.home.di

import android.app.Activity
import br.com.dagger.Constant
import br.com.dagger.R
import dagger.Module
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier annotation class Espanha
@Qualifier annotation class Brasil

@Module
@Singleton
class MsgModule(var activity: Activity) {

    @Provides
    @Espanha
    fun msgEspanha(): Info {
        return Info(activity.getString(R.string.tx_espanha))
    }

    @Provides
    @Brasil
    fun msgBrasil(): Info {
        return Info(activity.getString(R.string.tx_brasil))
    }
}

class Info(val text: String)