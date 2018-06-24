package br.com.dagger.content

import android.content.Context
import br.com.dagger.app.DaggerMyComponent_ContentComponent
import br.com.dagger.content.di.ContentModule
import javax.inject.Inject

class ContentPresenter(var view: ContentMVP.View): ContentMVP.Presenter {

    lateinit var context: Context
    @Inject
    lateinit var iteractor: ContentMVP.Iteractor
    //@Inject @field:AllMsgContent(Constant.HOME)
    //lateinit var msg: String


    override fun initView(context: Context?) {
        this.context = context!!
    }

    private fun initInjector() {
        var contentComponent = DaggerMyComponent_ContentComponent.builder()
                .contentModule(ContentModule(view))
                .build()
        contentComponent!!.inject(this)
    }

    override fun teste(context: Context) {
        //Toast.makeText(context, "${msg}", Toast.LENGTH_LONG).show()
        //Log.i("dagger>>", "${msg}")
        initInjector()
        iteractor.teste(context)


    }

    override fun showHome() {
        view.showHome()
    }

}