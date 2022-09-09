package com.example.chi_level2

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chi_level2.data.Datasource
import com.example.chi_level2.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var preferences: SharedPreferences

    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        preferences =
            binding.root.context?.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)!!

        val myDataset = Datasource().loadItemView()
        val key = arguments?.getInt("token", 0)
        val item = myDataset[key!!]

        binding.fragTvName.text = "Name: " + context?.resources?.getString(item.nameResourceId)
        binding.fragTvAge.text = "Age: " + context?.resources?.getString(item.ageResourceId)
        binding.fragSwitchBool.isChecked = preferences.getBoolean(key.toString(), false)

        return binding.root
    }
}