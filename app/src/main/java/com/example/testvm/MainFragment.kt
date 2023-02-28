package com.example.testvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.testvm.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    lateinit var binding: FragmentMainBinding
    private val viewModel: FragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.saveNewName(text = binding.editText.text.toString())
        }

        viewModel.mutableText.observe(viewLifecycleOwner) {
            binding.textView.text = it.name

        }

    }


    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}