package com.example.wprintapp.modules.remoteprinter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityRemotePrinterBinding
import com.example.wprintapp.modules.printoptions.ui.PrintOptionsActivity
import com.example.wprintapp.modules.remoteprinter.`data`.model.RemotePrinterRowModel
import com.example.wprintapp.modules.remoteprinter.`data`.viewmodel.RemotePrinterVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class RemotePrinterActivity :
    BaseActivity<ActivityRemotePrinterBinding>(R.layout.activity_remote_printer) {
  private val viewModel: RemotePrinterVM by viewModels<RemotePrinterVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val remotePrinterAdapter =
    RemotePrinterAdapter(viewModel.remotePrinterList.value?:mutableListOf())
    binding.recyclerRemotePrinter.adapter = remotePrinterAdapter
    remotePrinterAdapter.setOnItemClickListener(
    object : RemotePrinterAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : RemotePrinterRowModel) {
        onClickRecyclerRemotePrinter(view, position, item)
      }
    }
    )
    viewModel.remotePrinterList.observe(this) {
      remotePrinterAdapter.updateData(it)
    }
    binding.remotePrinterVM = viewModel
    setUpSearchViewAdvancedsearchListener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerRemotePrinter(
    view: View,
    position: Int,
    item: RemotePrinterRowModel
  ): Unit {
    when(view.id) {
      R.id.linearAddingtofava ->  {
        onClickRecyclerRemotePrinterLinearAddingtofava(view, position, item)
      }
    }
  }

  private fun setUpSearchViewAdvancedsearchListener(): Unit {
    binding.searchViewAdvancedsearch.setOnQueryTextListener(object :
    SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    fun onClickRecyclerRemotePrinterLinearAddingtofava(
      view: View,
      position: Int,
      item: RemotePrinterRowModel
    ) {
      /** TODO As per your logic, Add constant type for item click.*/
      when(0) {
        0 ->  {
          val destIntent = PrintOptionsActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        1 ->  {
          val destIntent = PrintOptionsActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        2 ->  {
          val destIntent = PrintOptionsActivity.getIntent(this, null)
          startActivity(destIntent)
        }
      }
    }

    companion object {
      const val TAG: String = "REMOTE_PRINTER_ACTIVITY"


      fun getIntent(context: Context, bundle: Bundle?): Intent {
        val destIntent = Intent(context, RemotePrinterActivity::class.java)
        destIntent.putExtra("bundle", bundle)
        return destIntent
      }
    }
  }
