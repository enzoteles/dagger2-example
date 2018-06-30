package br.com.dagger.home

import android.app.Fragment
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.dagger.R
import br.com.dagger.app.AppModule
import br.com.dagger.app.DaggerMyComponent_HomeComponent
import br.com.dagger.card.Card
import br.com.dagger.home.di.*
import javax.inject.Inject

class HomeFragment : Fragment(), HomeMVP.View {

    @Inject
    lateinit var presenter: HomeMVP.Presenter
    @Inject
    @field:Brasil
    lateinit var info: Info
    var listCard: ArrayList<Card>? = null
    var listCardShow: ArrayList<Card>? = null


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.home, container, false)
        initInjector()
        setList()
        return view
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun initInjector() {
        var homeComponent = DaggerMyComponent_HomeComponent.builder()
                .homeModule(HomeModule(this))
                .appModule(AppModule(activity.application))
                .msgModule(MsgModule(activity))
                .build()

        homeComponent!!.inject(this)
        presenter.teste(activity.baseContext, activity)
        Log.i("MSG>>>>", "${info.text}")
    }

    override fun setList() {
        listCard = ArrayList<Card>()
        listCardShow = ArrayList<Card>()


        var cardRef: Card = Card("Refeição", 12211, 20000.toDouble(), 0, "ativo")
        var cardSal = Card("Salário", 12211, 20000.toDouble(), 0, "ativo")
        var cardPag = Card("Pagamento", 12211, 20000.toDouble(), 0, "ativo")
        var cardAli = Card("Alimentação", 12211, 20000.toDouble(), 0, "ativo")
        var cardPre = Card("Presentes", 12211, 20000.toDouble(), 0, "ativo")

        listCard!!.add(cardRef)
        listCard!!.add(cardSal)
        listCard!!.add(cardPag)
        listCard!!.add(cardAli)
        listCard!!.add(cardPre)


        listCard!!.forEach { it ->

            it.position = if (it.name.equals("Refeição") && it.situation.equals("ativo")) 1 else 0
            /*it.position = if (it.name.equals("Salário") && it.situation.equals("ativo")) 2 else 7
            it.position = if (it.name.equals("Pagamento") && it.situation.equals("ativo")) 3 else 8
            it.position = if (it.name.equals("Alimentação") && it.situation.equals("ativo")) 4 else 9
            it.position = if (it.name.equals("Presentes") && it.situation.equals("ativo")) 5 else 10*/

            listCardShow!!.add(it)
        }

        listCardShow!!.forEach {
            it-> Log.i("LIST", "${it.name}")
        }


    }


}







