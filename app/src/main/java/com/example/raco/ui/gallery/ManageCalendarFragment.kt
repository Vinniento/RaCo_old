package com.example.raco.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.raco.R

class ManageCalendarFragment : Fragment() {

    private lateinit var manageCalendarViewModel: ManageCalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        manageCalendarViewModel =
            ViewModelProviders.of(this).get(ManageCalendarViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_manage_calendar, container, false)
        val textView: TextView = root.findViewById(R.id.text_manage_calendar)
        manageCalendarViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
