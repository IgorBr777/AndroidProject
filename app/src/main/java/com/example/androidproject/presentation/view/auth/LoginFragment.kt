package com.example.androidproject.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidproject.R
import com.example.androidproject.databinding.FragmentLoginBinding
import com.example.androidproject.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding: FragmentLoginBinding get() = _binding!!


    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      binding.btnShowCreds.setOnClickListener {

viewModel.loginUser(
    binding.etUserName.text.toString(),
    binding.etUserPassword.text.toString()

)
      }

        viewModel.nav.observe(viewLifecycleOwner){
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, HomeFragment())
                .commit()

        }

    }


}
