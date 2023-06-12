package com.example.wprintapp.modules.history.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseFragment
import com.example.wprintapp.databinding.FragmentHistoryBinding
import com.example.wprintapp.modules.history.`data`.model.HistoryRowModel
import com.example.wprintapp.modules.history.`data`.viewmodel.HistoryVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class HistoryFragment : BaseFragment<FragmentHistoryBinding>(R.layout.fragment_history) {
  private val viewModel: HistoryVM by viewModels<HistoryVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val historyAdapter = HistoryAdapter(viewModel.historyList.value?:mutableListOf())
    binding.recyclerHistory.adapter = historyAdapter
    historyAdapter.setOnItemClickListener(
    object : HistoryAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : HistoryRowModel) {
        onClickRecyclerHistory(view, position, item)
      }
    }
    )
    viewModel.historyList.observe(requireActivity()) {
      historyAdapter.updateData(it)
    }
    binding.historyVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerHistory(
    view: View,
    position: Int,
    item: HistoryRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "HISTORY_FRAGMENT"


    fun getInstance(bundle: Bundle?): HistoryFragment {
      val fragment = HistoryFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
