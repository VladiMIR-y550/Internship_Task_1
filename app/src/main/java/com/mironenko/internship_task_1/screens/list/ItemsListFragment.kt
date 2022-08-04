package com.mironenko.internship_task_1.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.databinding.FragmentItemsListBinding
import com.mironenko.internship_task_1.factory
import com.mironenko.internship_task_1.model.Item
import com.mironenko.internship_task_1.screens.detail.ItemDetailFragment
import com.mironenko.internship_task_1.screens.list.adapter.ItemClickListener
import com.mironenko.internship_task_1.screens.list.adapter.ItemsListAdapter

class ItemsListFragment : Fragment(), ItemClickListener {

    private var _binding: FragmentItemsListBinding? = null
    private val mBinding get() = _binding!!
    private val listAdapter: ItemsListAdapter by lazy { ItemsListAdapter(this) }
    private val viewModel: ItemsListViewModel by viewModels { factory() }
    private val itemsObserver: Observer<List<Item>> = Observer { listAdapter.setItemsList(it) }

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
        listAdapter.stateRestorationPolicy =
            RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY

        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
            this.setHasFixedSize(true)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.items.observe(viewLifecycleOwner, itemsObserver)
    }

    override fun onStop() {
        super.onStop()
        viewModel.items.removeObserver(itemsObserver)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onItemClick(itemId: Int) {
        viewModel.saveItemIdInPref(itemId)

        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ItemDetailFragment.newInstance(itemId))
            .addToBackStack(null)
            .commit()
    }
}