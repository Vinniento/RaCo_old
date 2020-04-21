package com.example.raco.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.raco.R
import com.example.raco.UserDetailsDataClass
import com.example.raco.databinding.FragmentResetpasswordBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_resetpassword.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ResetPasswordFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var user: FirebaseUser
    private lateinit var binding: FragmentResetpasswordBinding
    private var userBinding: UserDetailsDataClass = UserDetailsDataClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_resetpassword, container, false)
        val view: View = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userDetails = userBinding

        binding.buttonResetPassword.setOnClickListener {
            resetPassword(it)
        }

    }


    private fun resetPassword(view: View) {
        binding.apply {
            invalidateAll()
            userBinding.userMail = emailReset.text.toString()
        }
        auth.sendPasswordResetEmail(email_reset.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful)
                    Toast.makeText(activity, "Password reset", Toast.LENGTH_LONG).show()
                else
                    Toast.makeText(activity, "Password couldn't be reset", Toast.LENGTH_LONG)
                        .show()

            }
    }
}

