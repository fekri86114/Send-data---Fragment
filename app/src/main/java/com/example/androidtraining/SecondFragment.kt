package com.example.androidtraining

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidtraining.databinding.SecondFragmentBinding

class SecondFragment: Fragment() {
    lateinit var binding: SecondFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        if (bundle != null) {

            val mText = bundle.getString(USER_SEND_DATA_KEY)
            binding.txtShowName.text = mText

        } else {

            binding.txtShowName.text = "No information sent!"

        }

    }
}