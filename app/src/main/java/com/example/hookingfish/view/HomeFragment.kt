package com.example.hookingfish.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.hookingfish.R
import com.example.hookingfish.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        view.findViewById<FloatingActionButton>(R.id.fabhome).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_nav_home_to_nav_modality)
        }


        return view

    }


}

