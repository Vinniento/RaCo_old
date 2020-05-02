package com.example.raco.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.raco.R
import com.example.raco.databinding.FragmentResetpasswordBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ResetPasswordFragment : Fragment() {
    // private lateinit var auth: FirebaseAuth
    //private lateinit var user: FirebaseUser

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding =
            DataBindingUtil.inflate<FragmentResetpasswordBinding>(
                inflater,
                R.layout.fragment_resetpassword,
                container,
                false
            )
        binding.buttonResetPassword.setOnClickListener {
            resetPassword()
        }
        return binding.root
    }

    //TODO implement
    private fun resetPassword() {

    }
}

