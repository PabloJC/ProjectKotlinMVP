package com.mibaldi.proyectkotlin.home


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.mibaldi.proyectkotlin.detail.DetailActivity
import com.mibaldi.proyectkotlin.R
import com.mibaldi.proyectkotlin.app
import com.mibaldi.proyectkotlin.base.BaseMvpActivity
import com.mibaldi.proyectkotlin.models.Item
import com.mibaldi.proyectkotlin.repositories.Repository
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseMvpActivity<RepositoriesContract.View,
        HomePresenter>(),
        RepositoriesContract.View {

    private var mAdapter: ItemAdapter? = null

    @Inject
    lateinit var repository: Repository

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
            startActivity(DetailActivity.newIntent(this, it.id))
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
