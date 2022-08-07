package com.mironenko.internship_task_1.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.databinding.FragmentItemDetailsBinding
import com.mironenko.internship_task_1.util.factory

class ItemDetailFragment : Fragment() {
    private var _binding: FragmentItemDetailsBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: ItemDetailViewModel by viewModels { factory(itemId = itemId) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::renderState)
        viewModel.loadItem()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private val itemId by lazy {
        arguments?.getInt(ARG_USER_ID, -1) ?: -1
    }

    private fun renderState(newState: ItemDetailState) {
        newState.item?.also { item ->
            mBinding.tvItemId.text = getString(R.string.id_detail, item.id)
            mBinding.tvItemName.text = item.name
            mBinding.tvItemDescription.text = item.description
        }
    }

    companion object {
        private const val ARG_USER_ID = "ARG_USER_ID"

        fun newInstance(userId: Int): ItemDetailFragment {
            val fragment = ItemDetailFragment()
            fragment.arguments = bundleOf(ARG_USER_ID to userId)
            return fragment
        }
    }
}