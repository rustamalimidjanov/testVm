package com.example.testvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.testvm.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    lateinit var binding: FragmentMainBinding
    lateinit var dataName: Name

    private val nameViewModel: FragmentNameViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        dataName = Name()

        binding.button.setOnClickListener {
            val tvText = binding.editText.text.toString()
            newName(name = tvText)
        }

        nameViewModel.mutableNameText.observe(viewLifecycleOwner) {
            it?.let {
                this.dataName = it
                updateUI()
            }
        }

    }
    private fun newName(name: String) {
        nameViewModel.saveNewName(text = name)
    }

    private fun updateUI() {
        binding.textView.text = dataName.name
        binding.editText.setText(dataName.name)
    }


    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}