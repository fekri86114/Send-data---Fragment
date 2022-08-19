package com.example.androidtraining

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.androidtraining.databinding.FirstFragmentBinding


const val USER_SEND_DATA_KEY = "USER_NAME"
const val SEND_PARCELABLE_KEY = "PERSON_DATA"

class FirstFragment : Fragment() {
    lateinit var binding: FirstFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FirstFragmentBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnGoToSecondFragment.setOnClickListener {

            val name = binding.edtName.text.toString()
            val lastname = binding.edtLastname.text.toString()
            val age = binding.edtAge.text.toString()
            val gender = binding.edtGender.text.toString()

            if (name.isEmpty() && lastname.isEmpty()) {
                Toast.makeText(context, "Please, fill out all!", Toast.LENGTH_SHORT).show()
            } else {

                val data = Person(name, lastname, age, gender)

                val bundle = Bundle()
                bundle.putParcelable(SEND_PARCELABLE_KEY, data)

                // set data to SecondFragment() by Bundle()
                val fragment = SecondFragment()
                fragment.arguments = bundle

                val transaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_main_container, fragment)
                transaction.addToBackStack(null)
                transaction.commit()

            }
        }

    }

}