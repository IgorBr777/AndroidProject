package com.example.androidproject.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.utils.BundleConstants
import com.example.androidproject.presentation.view.adapter.ItemsAdapter
import com.example.androidproject.presentation.view.adapter.listener.ItemsListener
import com.example.androidproject.databinding.FragmentItemsBinding
import com.example.androidproject.utils.NavigationExt
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsListener {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!


    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = itemsAdapter

        viewModel.getData()
        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)

        }
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_LONG).show()

        }
        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {

                val detailsFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString(BundleConstants.NAME, navBundle.name)
                bundle.putString(BundleConstants.DATE, navBundle.date)
                bundle.putInt(BundleConstants.IMAGE_VIEW, navBundle.image)
                detailsFragment.arguments = bundle


                NavigationExt.fmReplace(parentFragmentManager, detailsFragment, true)

                viewModel.userNavigated()

            }

        }

    }

    override fun onClick() {

        viewModel.imageViewClick()
    }

    override fun onElementSelected(name: String, date: String, imageView: Int) {
        viewModel.elementClicked(name, date, imageView)
    }

}

