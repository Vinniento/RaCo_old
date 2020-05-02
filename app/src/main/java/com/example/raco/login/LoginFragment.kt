package com.example.raco.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.raco.R
import com.example.raco.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        //onclickListeners
        binding.buttonLogin.setOnClickListener {
            email.setText("schauervincent@gmail.com")
            password.setText("nlkjnlkj")
            if (!email.text.toString().isBlank() && !password.text.toString().isBlank())
                login(email.text.toString(), password.text.toString())
            else
                Toast.makeText(
                    context,
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
        return binding.root
    }



    fun login(email: String, password: String) {
        //für wenzl zeig zwecke hier

        updateUI()

    }

    //TODO add parameter of class user in future
    fun updateUI() {
        //TODO abfragen ob coach oder spieler

    }


}
