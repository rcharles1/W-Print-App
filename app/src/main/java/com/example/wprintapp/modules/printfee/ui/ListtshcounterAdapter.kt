package com.example.wprintapp.modules.printfee.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wprintapp.R
import com.example.wprintapp.databinding.RowListtshcounterBinding
import com.example.wprintapp.modules.printfee.`data`.model.ListtshcounterRowModel
import kotlin.Int
import kotlin.collections.List

class ListtshcounterAdapter(
  var list: List<ListtshcounterRowModel>
) : RecyclerView.Adapter<ListtshcounterAdapter.RowListtshcounterVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListtshcounterVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_listtshcounter,parent,false)
    return RowListtshcounterVH(view)
  }

  override fun onBindViewHolder(holder: RowListtshcounterVH, position: Int) {
    val listtshcounterRowModel = ListtshcounterRowModel()
    // TODO uncomment following line after integration with data source
    // val listtshcounterRowModel = list[position]
    holder.binding.listtshcounterRowModel = listtshcounterRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ListtshcounterRowModel>) {
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
      item: ListtshcounterRowModel
    ) {
    }
  }

  inner class RowListtshcounterVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListtshcounterBinding = RowListtshcounterBinding.bind(itemView)
  }
}
