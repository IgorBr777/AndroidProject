package com.example.androidproject.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidproject.R
import com.example.androidproject.utils.BundleConstants
import com.example.androidproject.databinding.FragmentDetailsBinding
import com.example.androidproject.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!


    private  val viewModel:DetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = safeBundle.getString(BundleConstants.NAME)
            val date = safeBundle.getString(BundleConstants.DATE)
            val image = safeBundle.getInt(BundleConstants.IMAGE_VIEW)

            viewBinding.detailsName.text = name
            viewBinding.detailsDate.text = date
            viewBinding.detailsImage.setBackgroundResource(image)

        }

viewBinding.btnLogout.setOnClickListener {
    viewModel.logoutUser()

    viewModel.nav.observe(viewLifecycleOwner){
        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container, LoginFragment())
            .commit()




    }


}




    }

}
