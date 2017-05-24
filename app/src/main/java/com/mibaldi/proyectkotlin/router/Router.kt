package com.mibaldi.proyectkotlin.router

import android.content.Context
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import com.mibaldi.proyectkotlin.ui.activities.DetailActivity


/**
 * Created by mikelbalducieldiaz on 24/5/17.
 */
class Router(val applicationContext: Context) {

    fun finishActivity(activityContext: Context?) {
        if (activityContext != null) {
            (activityContext as AppCompatActivity).finish()
        }
    }

    fun goToDetailActivity(id: Long) {
        val intent = Intent(applicationContext, DetailActivity::class.java).apply {
            putExtra(DetailActivity.EXTRA_ID, id)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        applicationContext.startActivity(intent)
    }


}