package com.mironenko.internship_task_1.screens.detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.mironenko.internship_task_1.PREFERENCE_FILE_KEY
import com.mironenko.internship_task_1.R
import com.mironenko.internship_task_1.SAVED_ITEM_ID
import com.mironenko.internship_task_1.databinding.FragmentItemDetailsBinding
import com.mironenko.internship_task_1.model.Item

class ItemDetailFragment : Fragment(),
    ItemDetailContract.View {
    private var _binding: FragmentItemDetailsBinding? = null
    private val mBinding get() = _binding!!
    private val presenter: ItemDetailContract.Presenter = ItemDetailPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.attachView(this)
    }

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

        Log.d(TAG, getSharedPrefItemId().toString())

        arguments?.let {
            val itemId = it.getInt(ARG_USER_ID)
            presenter.getItemById(itemId)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onDetach() {
        presenter.detachView()
        super.onDetach()
    }

    override fun showItemDetail(item: Item) {
        mBinding.tvItemId.text = getString(R.string.id_detail, item.id)
        mBinding.tvItemName.text = item.name
        mBinding.tvItemDescription.text = item.description
    }

    private fun getSharedPrefItemId(): Int {
        return requireContext().getSharedPreferences(
            PREFERENCE_FILE_KEY,
            Context.MODE_PRIVATE
        ).getInt(
            SAVED_ITEM_ID, -1
        )
    }

    companion object {
        private const val ARG_USER_ID = "ARG_USER_ID"
        private const val TAG = "TAG"

        fun newInstance(userId: Int): ItemDetailFragment {
            val fragment = ItemDetailFragment()
            fragment.arguments = bundleOf(ARG_USER_ID to userId)
            return fragment
        }
    }
}