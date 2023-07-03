package com.example.hookingfish

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.core.graphics.alpha
import androidx.core.graphics.blue
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import de.hdodenhof.circleimageview.CircleImageView
import java.util.Calendar

class StartFragment : Fragment(){
    private lateinit var button: Button
    val c  = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH)
    val day = c.get(Calendar.DAY_OF_MONTH)
    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        view.findViewById<Button>(R.id.buttonStart).setOnClickListener {

           val dpd = DatePickerDialog(requireContext(),DatePickerDialog.OnDateSetListener{ datePicker, i, i2, i3 ->

           },year,month,day)
            dpd.show()

        }
        view.findViewById<Button>(R.id.buttonfinish).setOnClickListener {

            val dpd = DatePickerDialog(requireContext(),DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
            },year,month,day)
            dpd.show()
        }

        view.findViewById<Button>(R.id.button_save_start).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_nav_start_to_nav_home)
        }

        return view
    }













}


