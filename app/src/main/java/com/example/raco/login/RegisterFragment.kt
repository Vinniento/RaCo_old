package com.example.raco.login

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.raco.R
import com.example.raco.UserDetailsDataClass
import com.example.raco.databinding.FragmentRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_register.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RegisterFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var currentUser: FirebaseUser
    private lateinit var binding: FragmentRegisterBinding
    private val userDetails: UserDetailsDataClass = UserDetailsDataClass()
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        val view: View = binding.root
        return view
    }

    override fun onStart() {
        super.onStart()
        //check if user is signed in and set appropriate UI
        currentUser = auth.currentUser!!
        updateUI(currentUser)
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
            createAccount(email_reg.text.toString(), this.password_one.text.toString())
            // updateUserInfo(currentUser)
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


    private fun createAccount(email: String, password: String) {
        database = Firebase.database.reference

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(ContentValues.TAG, "createUserWithEmail:success")
                    Toast.makeText(activity, "Authentication Successful!!", Toast.LENGTH_SHORT)
                        .show()
                    val user = auth.currentUser
                    user?.sendEmailVerification()
                    //user.uid.updateProfile()

                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(ContentValues.TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        activity,
                        "Authentication failed. ${task.exception}",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }

                // ...
            }
    }

    private fun updateUserInfo(user: FirebaseUser?) {

        auth.updateCurrentUser(user!!)
        val userInfo =
            UserDetailsDataClass(firstName = userDetails.firstName, lastName = userDetails.lastName)
        if (user != null) {
            database.child("users").child(user.uid).setValue(userInfo)
        }
    }

    private fun updateUI(user: FirebaseUser?) {

        //hier dann zur appropriate activity/fraggment weiterleiten
    }


}
