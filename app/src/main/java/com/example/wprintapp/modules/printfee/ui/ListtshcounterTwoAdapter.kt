package com.example.wprintapp.modules.printfee.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wprintapp.R
import com.example.wprintapp.databinding.RowListtshcounterTwoBinding
import com.example.wprintapp.modules.printfee.`data`.model.ListtshcounterTwoRowModel
import kotlin.Int
import kotlin.collections.List

class ListtshcounterTwoAdapter(
  var list: List<ListtshcounterTwoRowModel>
) : RecyclerView.Adapter<ListtshcounterTwoAdapter.RowListtshcounterTwoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListtshcounterTwoVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listtshcounter_two,parent,false)
    return RowListtshcounterTwoVH(view)
  }

  override fun onBindViewHolder(holder: RowListtshcounterTwoVH, position: Int) {
    val listtshcounterTwoRowModel = ListtshcounterTwoRowModel()
    // TODO uncomment following line after integration with data source
    // val listtshcounterTwoRowModel = list[position]
    holder.binding.listtshcounterTwoRowModel = listtshcounterTwoRowModel
  }

  override fun getItemCount(): Int = 5
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListtshcounterTwoRowModel>) {
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
      item: ListtshcounterTwoRowModel
    ) {
    }
  }

  inner class RowListtshcounterTwoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListtshcounterTwoBinding = RowListtshcounterTwoBinding.bind(itemView)
  }
}
