package com.example.androidproject.presentation.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.androidproject.R

object NavigationExt {

    fun fmReplace(
        parentFragmentManager: FragmentManager,
        fragment: Fragment,
        addToBackStack: Boolean

    ) {
        if (addToBackStack) {
            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container, fragment)
                .addToBackStack(R.string.details.toString())
                .commit()

        } else {

            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, fragment)
                .commit()
        }

    }
}