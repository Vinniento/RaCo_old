package com.example.raco.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.raco.R
import com.example.raco.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_resetpassword.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ResetPasswordFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
    }
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resetpassword, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_reset_password.setOnClickListener {
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
}
