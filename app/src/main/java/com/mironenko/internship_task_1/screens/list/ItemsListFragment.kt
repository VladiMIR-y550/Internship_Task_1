package com.mironenko.internship_task_1.screens.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.databinding.FragmentItemsListBinding
import com.mironenko.internship_task_1.factory
import com.mironenko.internship_task_1.screens.detail.ItemDetailFragment
import com.mironenko.internship_task_1.screens.list.adapter.ItemClickListener
import com.mironenko.internship_task_1.screens.list.adapter.ItemsListAdapter

class ItemsListFragment : Fragment(), ItemClickListener {

    private var _binding: FragmentItemsListBinding? = null
    private val mBinding get() = _binding!!
    private val listAdapter: ItemsListAdapter by lazy { ItemsListAdapter(this) }
    private val viewModel: ItemsListViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemsListBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.items.observe(viewLifecycleOwner) { state ->
            if (state.isLoading) {
                Toast.makeText(requireContext(), "List items loading", Toast.LENGTH_SHORT)
                    .show()
            } else {
                if (state.data != null) {
                    listAdapter.submitList(state.data)
                } else {
                    if (state.errorMessage != null) {
                        Log.e(ItemsListFragment::class.java.simpleName, state.errorMessage)
                    } else {
                        Toast.makeText(requireContext(), "List items is Empty", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

        listAdapter.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
            this.setHasFixedSize(true)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onItemClick(itemId: Int) {
        viewModel.saveItemId(itemId)

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ItemDetailFragment.newInstance(itemId))
            .addToBackStack(null)
            .commit()
    }
}