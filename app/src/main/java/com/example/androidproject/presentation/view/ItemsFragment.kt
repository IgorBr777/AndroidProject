package com.example.androidproject.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.data.ItemRepositoryImpl
import com.example.androidproject.databinding.FragmentItemsBinding
import com.example.androidproject.databinding.FragmentOnBoardingBinding
import com.example.androidproject.domain.ItemsInteractor
import com.example.androidproject.presentation.adapter.ItemsAdapter
import com.example.androidproject.presentation.adapter.listener.ItemsListener
import com.example.androidproject.model.ItemsModel


class ItemsFragment : Fragment(), ItemsListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemsPresenter= ItemsPresenter(this, ItemsInteractor(ItemRepositoryImpl()))


        itemsAdapter = ItemsAdapter(this)

        viewBinding.recyclerView.adapter = itemsAdapter


        itemsPresenter.getData()

    }

    override fun onClick() {

        itemsPresenter.imageViewClicked()


    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {

        itemsPresenter.elementSelected(name,date,imageView)


    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg:Int) {

        Toast.makeText(context, getString(msg), Toast.LENGTH_LONG).show()
    }

    override fun goToDetails(name: String, date: String, imageView: Int) {

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