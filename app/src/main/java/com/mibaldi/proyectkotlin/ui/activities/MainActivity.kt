package com.mibaldi.proyectkotlin.ui.activities


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.mibaldi.proyectkotlin.R
import com.mibaldi.proyectkotlin.utils.app
import com.mibaldi.proyectkotlin.base.BaseMvpActivity
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.HomeModule
import com.mibaldi.proyectkotlin.ui.presenters.homeActivity.HomePresenter
import com.mibaldi.proyectkotlin.ui.adapters.ItemAdapter
import com.mibaldi.proyectkotlin.ui.views.HomeContract
import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.data.repositories.Repository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseMvpActivity<HomeContract.View,
        HomePresenter>(),
        HomeContract.View {

    private var mAdapter: ItemAdapter? = null

    @field:[Inject Named("ApiManager")]
    lateinit var something: String

    override var mPresenter: HomePresenter = HomePresenter(this)

    val component by lazy { app.component.plus(HomeModule(this)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)
        setUpRecyclerView()
        Log.d("MAIN",something)
        mPresenter.init()
        mPresenter.loadRepositories()
    }


    override fun showOrganizations(items: List<Item>) {
        mAdapter?.addRepositories(items)
        mAdapter?.notifyDataSetChanged()
        recycler.adapter = mAdapter
        hideProgress()
    }

    private fun setUpRecyclerView() {
        mAdapter = ItemAdapter(ArrayList<Item>(), {
            mPresenter.goToDetail(it.id)
        })
        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler.adapter = mAdapter
    }

    override fun showProgress() {
        recycler.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        recycler.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun showError(error: String?) {
        super.showError(error)
        progressBar.visibility = View.GONE
    }
}
