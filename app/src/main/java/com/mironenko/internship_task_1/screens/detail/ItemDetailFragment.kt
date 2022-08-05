package com.mironenko.internship_task_1.screens.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.databinding.FragmentItemDetailsBinding
import com.mironenko.internship_task_1.factory
import com.mironenko.internship_task_1.model.Item
import com.mironenko.internship_task_1.screens.list.ItemsListFragment

class ItemDetailFragment : Fragment() {
    private var _binding: FragmentItemDetailsBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: ItemDetailViewModel by viewModels { factory() }

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

        viewModel.item.observe(viewLifecycleOwner) { state ->
            if (state.isLoading) {
                Toast.makeText(requireContext(), "Item is loading", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (state.data != null) {
                    showItem(state.data)
                } else {
                    if (state.errorMessage != null) {
                        Log.e(ItemsListFragment::class.java.simpleName, state.errorMessage)
                    } else {
                        Toast.makeText(requireContext(), "No Items", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

        arguments?.let {
            val itemId = it.getInt(ARG_USER_ID)
            viewModel.getItemById(itemId)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun showItem(item: Item) {
        mBinding.tvItemId.text = getString(R.string.id_detail, item.id)
        mBinding.tvItemName.text = item.name
        mBinding.tvItemDescription.text = item.description
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