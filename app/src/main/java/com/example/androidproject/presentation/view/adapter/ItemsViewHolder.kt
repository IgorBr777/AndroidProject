package com.example.androidproject.presentation.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.presentation.view.adapter.listener.ItemsListener
import com.example.androidproject.model.ItemsModel

class ItemsViewHolder(private val view: View,
                      private val itemsListener: ItemsListener
                      ) : RecyclerView.ViewHolder(view) {

    fun bind(itemsModel: ItemsModel) {
        val name = view.findViewById<TextView>(R.id.tv_name)
        val imageView = view.findViewById<ImageView>(R.id.iv_image)
        val date = view.findViewById<TextView>(R.id.tv_date)


        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        name.text = itemsModel.date

        //   name.text =string

        imageView.setOnClickListener {
            itemsListener.onClick()
        }

        itemView.setOnClickListener{

            itemsListener.onElementSelected(
                itemsModel.name,
                itemsModel.date,
                itemsModel.image

            )

        }


    }

}