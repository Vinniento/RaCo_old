package com.example.raco.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.raco.R
import com.example.raco.UserDetailsDataClass
import com.example.raco.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {
    // private lateinit var auth: FirebaseAuth
    //private lateinit var currentUser: FirebaseUser
    private lateinit var binding: FragmentRegisterBinding
    private val userDetails: UserDetailsDataClass = UserDetailsDataClass()
    //private lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userDetails = userDetails
        binding.apply {
            //TODO überlegen ob pw auch?
            userDetails?.userMail = emailReg.text.toString()
            userDetails?.firstName = firstnameRegister.text.toString()
            userDetails?.lastName = lastnameRegister.text.toString()
        }
        binding.buttonRegister.setOnClickListener {
            createAccount()

        }
        val spinnerClubs: Spinner = spinner_clubs
        val spinnerCountries: Spinner = spinner_countries
        //spinner_clubs.findViewById(R.id.spinner_clubs)
        // Create an ArrayAdapter using the string array and a default spinner layout
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.clubs_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinnerClubs.adapter = adapter
            }
        }

        this.context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.countries_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinnerCountries.adapter = adapter
            }
        }


    }

    /**
     *Creates and account
     * @param user - data class object for login
     */
    private fun createAccount() {

    }


    private fun updateUI(user: FirebaseUser?) {

        //hier dann zur appropriate activity/fraggment weiterleiten
    }


}
