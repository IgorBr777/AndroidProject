package com.example.androidproject.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentItemsBinding
import com.example.androidproject.model.ItemsModel
import com.example.androidproject.presentation.view.adapter.ItemsAdapter
import com.example.androidproject.presentation.view.adapter.listener.ItemsListener
import com.example.androidproject.utils.BundleConstants
import com.example.androidproject.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener, ItemsView {



    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!


    private lateinit var itemsAdapter: ItemsAdapter

@Inject
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
        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()


    }

    override fun onClick() {

       itemsPresenter.imageViewClick()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        itemsPresenter.itemClick(name, date, imageView)
    }

    override fun itemsReceive(itemsList: List<ItemsModel>) {
        itemsAdapter.submitList(itemsList)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_LONG).show()
    }

    override fun itemClicked(navigationData: NavigateWithBundle) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(BundleConstants.NAME, navigationData.name)
        bundle.putString(BundleConstants.DATE, navigationData.date)
        bundle.putInt(BundleConstants.IMAGE_VIEW, navigationData.image)
        detailsFragment.arguments = bundle

        NavigationExt.fmReplace(parentFragmentManager, detailsFragment, true)

    }

}

