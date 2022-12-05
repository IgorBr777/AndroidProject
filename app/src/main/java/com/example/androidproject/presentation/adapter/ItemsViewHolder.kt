package com.example.androidproject.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.androidproject.R
import com.example.androidproject.databinding.ItemFruitBinding
import com.example.androidproject.presentation.adapter.listener.ItemsListener
import com.example.androidproject.model.ItemsModel

class ItemsViewHolder(
    private  val viewBinding: ItemFruitBinding,

    private val itemsListener: ItemsListener
                      ) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel) {


        viewBinding.tvName.text = itemsModel.name
        viewBinding. ivImage.setBackgroundResource(itemsModel.image)
        viewBinding.tvDate.text = itemsModel.date

        //   name.text =string

        viewBinding.ivImage.setOnClickListener {
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