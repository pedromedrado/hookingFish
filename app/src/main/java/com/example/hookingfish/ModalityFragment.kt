package com.example.hookingfish

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import de.hdodenhof.circleimageview.CircleImageView

class ModalityFragment : Fragment() {
    private lateinit var toolbarmodal: Toolbar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_modality, container, false)


        view.findViewById<CircleImageView>(R.id.cicle1).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modality_to_nav_modal)
        }

        view.findViewById<CircleImageView>(R.id.cicle2).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modality_to_nav_modal1)
        }

        view.findViewById<CircleImageView>(R.id.cicle3).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_modality_to_nav_modal2)
        }

        return view
    }


}


