package com.mironenko.internship_task_1.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.databinding.FragmentItemDetailsBinding
import com.mironenko.internship_task_1.factory
import com.mironenko.internship_task_1.model.Item

class ItemDetailFragment : Fragment() {
    private var _binding: FragmentItemDetailsBinding? = null
    private val mBinding get() = _binding!!
    private val viewModel: ItemDetailViewModel by viewModels { factory() }
    private val itemObserver: Observer<Item> = Observer { showItem(it) }

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

        arguments?.let {
            val itemId = it.getInt(ARG_USER_ID)
            viewModel.getItemById(itemId)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.item.observe(viewLifecycleOwner, itemObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.item.removeObserver(itemObserver)
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