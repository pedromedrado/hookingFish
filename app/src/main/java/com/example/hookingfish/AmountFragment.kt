package com.example.hookingfish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class AmountFragment : Fragment() {
    private lateinit var toolbarmodal: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_amount, container, false)


        view.findViewById<Button>(R.id.buttonsquadA).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modal2_to_nav_start)
        }

        view.findViewById<Button>(R.id.buttonsduplaA).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modal2_to_nav_start)
        }
        return view
    }


}


