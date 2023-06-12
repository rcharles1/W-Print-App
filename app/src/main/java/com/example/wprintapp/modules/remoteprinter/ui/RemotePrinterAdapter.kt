package com.example.wprintapp.modules.remoteprinter.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wprintapp.R
import com.example.wprintapp.databinding.RowRemotePrinterBinding
import com.example.wprintapp.modules.remoteprinter.`data`.model.RemotePrinterRowModel
import kotlin.Int
import kotlin.collections.List

class RemotePrinterAdapter(
  var list: List<RemotePrinterRowModel>
) : RecyclerView.Adapter<RemotePrinterAdapter.RowRemotePrinterVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowRemotePrinterVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_remote_printer,parent,false)
    return RowRemotePrinterVH(view)
  }

  override fun onBindViewHolder(holder: RowRemotePrinterVH, position: Int) {
    val remotePrinterRowModel = RemotePrinterRowModel()
    // TODO uncomment following line after integration with data source
    // val remotePrinterRowModel = list[position]
    holder.binding.remotePrinterRowModel = remotePrinterRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<RemotePrinterRowModel>) {
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
      item: RemotePrinterRowModel
    ) {
    }
  }

  inner class RowRemotePrinterVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowRemotePrinterBinding = RowRemotePrinterBinding.bind(itemView)
    init {
      binding.linearAddingtofava.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, RemotePrinterRowModel())
      }
    }
  }
}
