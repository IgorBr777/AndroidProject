package com.example.androidproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.adapter.ItemsAdapter
import com.example.androidproject.listener.ItemsListener
import com.example.androidproject.model.ItemsModel


class ItemsFragment : Fragment(), ItemsListener {

    private lateinit var itemsAdapter: ItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.banana, "Banana", "22.07.1999"),
            ItemsModel(R.drawable.android_1, "Android", "10.06.2022"),
            ItemsModel(R.drawable.android_2, "IOS", "15.02.2020"),
            ItemsModel(R.drawable.android_3, "Flutter", "30.11.1986"),
            ItemsModel(R.drawable.android_4, "Python", "18.08.1995"),
            ItemsModel(R.drawable.it_1, "PHP", "10.06.2004"),

            )
        itemsAdapter.submitList(listItems.toList())

    }

    override fun onClick() {
        Toast.makeText(context, "ImageView clicked", Toast.LENGTH_LONG).show()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("date", date)
        bundle.putInt("imageView", imageView)
        detailsFragment.arguments = bundle

// add метод мы больше не используем, нужно использовать replace
        // replace всегда будет иметь или addToBackStack, чтобы могли вернуться  назад или же его не будет,
        // чтобы мы могли вернуться назад.
        parentFragmentManager
            .beginTransaction()
            .add(R.id.activity_container, detailsFragment)
            .addToBackStack("Details")
            .commit()
    }
}