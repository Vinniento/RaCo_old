package com.example.raco.login

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.raco.NavigationDrawerActivity
import com.example.raco.R
import com.example.raco.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser

    private lateinit var binding: FragmentLoginBinding
    //private val userDetails: UserDetailsDataClass = UserDetailsDataClass(user.email.toString(), user.displayName.toString())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!


        // userDetails.userMail = email.text.toString()


    }

    //TODO
    public override fun onStart() {
        super.onStart()
        // TODO
        // Check if user is signed in (non-null) and update UI accordingly.
        // val currentUser = auth.currentUser
        //updateUI(currentUser)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        val view: View = binding.getRoot()
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            email.text = email.text

        }
        binding.buttonLogin.setOnClickListener {
            if (!email.text.toString().isBlank() && !password.text.toString().isBlank())
                login(email.text.toString(), password.text.toString())
            else
                Toast.makeText(
                    activity,
                    "Both email and password have to be set",
                    Toast.LENGTH_LONG
                ).show()
        }


        binding.buttonGoToRegister.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RegisterFragment)
        }

        binding.buttonGoToForgotpassword.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_resetPasswordFragment)
        }
    }


    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        activity, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    // updateUI(null)
                    // ...
                }

                // ...
            }
    }

    fun updateUI(user: FirebaseUser?) {
        //TODO abfragen ob coach oder spieler
        startActivity(Intent(activity, NavigationDrawerActivity::class.java))
        this.activity?.finish() //richtig?
    }


}
