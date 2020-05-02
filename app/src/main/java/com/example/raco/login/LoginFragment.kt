package com.example.raco.login

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
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
//TODO add conditional navigation if logged in or not
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
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }

        binding.buttonGoToForgotpassword.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToResetPasswordFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }


    fun login(email: String, password: String) {
        //für wenzl zeig zwecke hier
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())

        updateUI()

    }

    //TODO add parameter of class user in future
    fun updateUI() {
        //TODO abfragen ob coach oder spieler

    }


}
