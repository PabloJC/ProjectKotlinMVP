package com.mibaldi.proyectkotlin.detail

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mibaldi.proyectkotlin.R
import com.mibaldi.proyectkotlin.loadUrl
import com.mibaldi.proyectkotlin.models.getItems
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    companion object {

        private const val EXTRA_ID = "DetailActivity:Id"

        fun newIntent(context: Context, id: Long): Intent =
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(EXTRA_ID, id)
                }
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
}
