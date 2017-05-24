package com.mibaldi.proyectkotlin.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.mibaldi.proyectkotlin.data.models.Item
import com.mibaldi.proyectkotlin.R

import com.mibaldi.proyectkotlin.utils.inflate
import com.mibaldi.proyectkotlin.utils.loadUrl
import kotlinx.android.synthetic.main.view_item.view.*

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