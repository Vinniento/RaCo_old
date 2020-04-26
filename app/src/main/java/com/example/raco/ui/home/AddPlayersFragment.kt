package com.example.raco.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.raco.R

class AddPlayersFragment : Fragment() {

    private lateinit var addPlayersViewModel: AddPlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addPlayersViewModel =
            ViewModelProviders.of(this).get(AddPlayersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_players, container, false)
        val textView: TextView = root.findViewById(R.id.text_add_players)
        addPlayersViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
