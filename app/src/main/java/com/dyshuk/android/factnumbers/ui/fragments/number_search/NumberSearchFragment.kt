package com.dyshuk.android.factnumbers.ui.fragments.number_search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dyshuk.android.factnumbers.databinding.FragmentNumberSearchBinding
import com.dyshuk.android.factnumbers.ui.viewmodels.NumbersViewModel

class NumberSearchFragment : Fragment() {

    private var _binding: FragmentNumberSearchBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NumbersViewModel by lazy {
        val activity = requireNotNull(this.activity)
        ViewModelProvider(activity, NumbersViewModel.Factory(activity.application))[NumbersViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentNumberSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}