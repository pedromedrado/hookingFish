package com.example.hookingfish.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.hookingfish.R

class WeightFragment : Fragment() {
    private lateinit var toolbarmodal: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weight, container, false)

        view.findViewById<Button>(R.id.buttonsquadQ).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modal1_to_nav_start)
        }
        view.findViewById<Button>(R.id.buttonsduplaQ).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modal1_to_nav_start)
        }

        return view
    }


}


