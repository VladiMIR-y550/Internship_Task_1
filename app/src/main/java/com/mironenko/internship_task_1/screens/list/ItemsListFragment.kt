package com.mironenko.internship_task_1.screens.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.databinding.FragmentItemsListBinding
import com.mironenko.internship_task_1.model.ItemsService
import com.mironenko.internship_task_1.screens.detail.ItemDetailFragment

class ItemsListFragment : Fragment(), ItemClickListener {

    private var _binding: FragmentItemsListBinding? = null
    private val mBinding get() = _binding!!
    private val listAdapter: ItemsListAdapter by lazy { ItemsListAdapter(this) }

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
        listAdapter.setItemsList(ItemsService.getItemsList())

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
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ItemDetailFragment.newInstance(itemId))
            .addToBackStack(null)
            .commit()
    }
}