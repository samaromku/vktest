package ru.savchenko.andrey.vktest.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_new.*
import ru.savchenko.andrey.vktest.R
import ru.savchenko.andrey.vktest.base.BaseAdapter
import ru.savchenko.andrey.vktest.base.BaseViewHolder
import ru.savchenko.andrey.vktest.base.OnItemClickListener
import ru.savchenko.andrey.vktest.entities.Item

/**
 * Created by savchenko on 25.04.18.
 */
class MainAdapter(dataList: MutableList<Item>,
                  clickListener: OnItemClickListener) : BaseAdapter<Item>(dataList, clickListener) {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<Item> {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_new, parent, false)
        return NewsViewHolder(view)
    }

    class NewsViewHolder(val itemView: View) : BaseViewHolder<Item>(itemView) {
        override fun bind(t: Item, clickListener: OnItemClickListener) {
            super.bind(t, clickListener)
            if (t.attachments != null) {
                val photo = t.attachments[0].photo
                if (photo != null) {
                    ivAttachment.visibility = View.VISIBLE
                    Picasso.get()
                            .load(photo.photo604)
                            .into(ivAttachment)
                }else{
                    ivAttachment.visibility = View.GONE
                }
            }else{
                ivAttachment.visibility = View.GONE
            }
            tvBody.text = t.text
        }
    }
}