package com.example.androidproject.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentDetailsBinding
import com.example.androidproject.presentation.view.auth.LoginFragment
import com.example.androidproject.utils.BundleConstants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!


    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsPresenter.setView(this)


        val bundle = arguments
        bundle?.let { safeBundle ->

            detailsPresenter.getArguments(
                safeBundle.getString(BundleConstants.NAME),
                safeBundle.getString(BundleConstants.DATE),
                safeBundle.getInt(BundleConstants.IMAGE_VIEW)
            )

        }



        viewBinding.btnLogout.setOnClickListener {
            detailsPresenter.logoutUser()
        }


    }

    override fun userLoggedOut() {

        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()


    }

    override fun displayItemData(name: String, date: String, imageView: Int) {
        viewBinding.detailsName.text = name
        viewBinding.detailsDate.text = date
        viewBinding.detailsImage.setBackgroundResource(imageView)

    }


}


