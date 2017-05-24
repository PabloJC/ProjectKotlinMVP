package com.mibaldi.proyectkotlin.ui.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mibaldi.proyectkotlin.R
import com.mibaldi.proyectkotlin.base.BaseMvpActivity
import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.data.models.getItems
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.DetailPresenter
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.HomePresenter
import com.mibaldi.proyectkotlin.ui.views.DetailContract
import com.mibaldi.proyectkotlin.utils.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: BaseMvpActivity<DetailContract.View,
        DetailPresenter>(),
        DetailContract.View {


    override var mPresenter: DetailPresenter = DetailPresenter(this)
    companion object {

        const val EXTRA_ID = "DetailActivity:Id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getLongExtra(EXTRA_ID, -1)

        val item = getItems().firstOrNull{it.id == id}

        if (item != null)  {
            item_image.loadUrl(item.url)
            item_title.text = item.title
        }
    }

    override fun showOrganizations(items: List<Item>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
