package com.example.testvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testvm.databinding.FragmentMainBinding

class MainFragment: Fragment() {
    lateinit var binding: FragmentMainBinding
    lateinit var dataName: Name
    private val viewModel: FragmentViewModel by activityViewModels()
//    private val viewModel: FragmentViewModel by lazy {
//        ViewModelProvider(this)[FragmentViewModel::class.java]
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataName = Name()
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            val tvText = binding.editText.text.toString()
            newName(name = tvText)
        }

        viewModel.mutableText.observe(viewLifecycleOwner) {
//            binding.textView.text = it.name
            it?.let {
                this.dataName = it
                updateUI()
            }
        }

    }
    private fun newName(name: String) {
        viewModel.saveNewName(text = name)
    }

    private fun updateUI() {
        binding.textView.text = dataName.name
        binding.editText.setText(dataName.name)
    }


    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }
}