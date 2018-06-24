package br.com.dagger.content

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dagger.R
import br.com.dagger.app.AppModule
import br.com.dagger.app.DaggerMyComponent_ContentComponent
import br.com.dagger.content.di.ContentModule
import br.com.dagger.home.HomeFragment
import javax.inject.Inject

class ContentFragment: Fragment(), ContentMVP.View {

    //injection
    @Inject
    lateinit var presenter: ContentMVP.Presenter


    lateinit var manager: FragmentManager
    lateinit var transaction: FragmentTransaction

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.content, container, false)

        initInjector()
        initPresenter()
        return view
    }

    private fun initInjector() {
        //init
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        var contentComponent = DaggerMyComponent_ContentComponent.builder()
                .contentModule(ContentModule(this))
                .appModule(AppModule(activity.application))
                .build()
        contentComponent.inject(this)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    private fun initPresenter() {
        presenter.teste(context)
    }

    override fun showHome() {

        manager = fragmentManager
        transaction = manager.beginTransaction()
        transaction.add(R.id.content, HomeFragment(), "home")
        transaction.commit()

    }

}