package com.example.wprintapp.modules.history.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wprintapp.R
import com.example.wprintapp.databinding.RowHistoryBinding
import com.example.wprintapp.modules.history.`data`.model.HistoryRowModel
import kotlin.Int
import kotlin.collections.List

class HistoryAdapter(
  var list: List<HistoryRowModel>
) : RecyclerView.Adapter<HistoryAdapter.RowHistoryVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHistoryVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_history,parent,false)
    return RowHistoryVH(view)
  }

  override fun onBindViewHolder(holder: RowHistoryVH, position: Int) {
    val historyRowModel = HistoryRowModel()
    // TODO uncomment following line after integration with data source
    // val historyRowModel = list[position]
    holder.binding.historyRowModel = historyRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<HistoryRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: HistoryRowModel
    ) {
    }
  }

  inner class RowHistoryVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowHistoryBinding = RowHistoryBinding.bind(itemView)
  }
}
