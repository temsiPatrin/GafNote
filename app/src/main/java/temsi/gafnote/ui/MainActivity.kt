package temsi.gafnote.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.koin.androidx.fragment.android.setupKoinFragmentFactory
import temsi.gafnote.R
import temsi.gafnote.ui.editfragment.EditFragment
import temsi.gafnote.ui.mainfragment.MainFragment
import temsi.gafnote.ui.viewfragment.ViewFragment

class MainActivity : AppCompatActivity(),FragmentCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupKoinFragmentFactory()
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.frame,
                MainFragment::class.java,null,null)
            .commit()


    }

    override fun loadMainFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame,
                MainFragment::class.java,null,null)
            .commit()
    }

    override fun loadEditFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame,
                EditFragment::class.java,null,null)
            .commit()
    }

    override fun onItemClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame,ViewFragment::class.java,null,"View")
            .commit()
    }
}