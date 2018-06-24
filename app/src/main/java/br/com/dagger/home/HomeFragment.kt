package br.com.dagger.home

import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dagger.Constant
import br.com.dagger.R
import br.com.dagger.app.AppModule
import br.com.dagger.app.DaggerMyComponent_HomeComponent
import br.com.dagger.home.di.*
import javax.inject.Inject

class HomeFragment: Fragment(), HomeMVP.View{

    @Inject
    lateinit var presenter: HomeMVP.Presenter
    @Inject @field:Brasil
    lateinit var info: Info

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.home, container, false)
        initInjector()
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initInjector() {
        presenter.teste(context)
        Log.i("MSG>>>>", "${info.text}")
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        var homeComponent = DaggerMyComponent_HomeComponent.builder()
                .homeModule(HomeModule(this))
                .appModule(AppModule(activity.application))
                .msgModule(MsgModule(activity))
                .build()

        homeComponent!!.inject(this)

    }
}