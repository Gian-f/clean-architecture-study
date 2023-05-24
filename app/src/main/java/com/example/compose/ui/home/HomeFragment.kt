package com.example.compose.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.compose.databinding.FragmentHomeBinding
import com.example.compose.ui.home.adapters.ExampleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val exampleAdapter = ExampleAdapter()

    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        loadData()
        verifyEmptyList()
        setObservers()
    }

    private fun setObservers() {
        viewModel.exampleData.observe(viewLifecycleOwner) { examples ->
            binding.swipeExamples.isRefreshing = false
            exampleAdapter.submitList(examples)
        }
    }

    private fun loadData() {
        viewModel.getAllExamples()
    }

    private fun setRecyclerView() {
        binding.recyclerList.run {
            setHasFixedSize(true)
            adapter = exampleAdapter
            layoutManager= LinearLayoutManager(requireContext())
        }
    }

    private fun verifyEmptyList() {
        with(binding) {
            if (exampleAdapter.itemCount == 0) {
                emptyList.text = "Nenhum registro encontrado"
                emptyList.visibility = View.VISIBLE
            } else {
                emptyList.text = ""
                emptyList.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}