package br.com.dagger

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.dagger.content.ContentFragment
import br.com.dagger.content.ContentPresenter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var manager: FragmentManager
    lateinit var transaction: FragmentTransaction
    lateinit var contentFragment: ContentFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contentFragment = ContentFragment()
        manager = fragmentManager
        transaction = manager.beginTransaction()
        transaction.add(R.id.content, contentFragment, "content")
        transaction.commit()

    }
}
