package com.mibaldi.proyectkotlin.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mibaldi.proyectkotlin.models.Item
import com.mibaldi.proyectkotlin.R

import com.mibaldi.proyectkotlin.inflate
import com.mibaldi.proyectkotlin.loadUrl
import kotlinx.android.synthetic.main.activity_detail.view.*

/**
 * Created by mikelbalducieldiaz on 21/5/17.
 */
class ItemAdapter(private val items: MutableList<Item>, val listener: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewItem: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.view_item))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.itemView){
        val item =items.get(position)
        item_title.text = item.title
        item_image.loadUrl(item.url)
        setOnClickListener { listener(item) }
    }

    override fun getItemCount() = items.size



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)


    fun addRepositories(newRepositories: List<Item>) {
        items.addAll(newRepositories)
    }
}