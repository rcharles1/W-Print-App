package com.example.wprintapp.modules.printfee.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPrintFeeBinding
import com.example.wprintapp.modules.printfee.`data`.model.ListtshcounterRowModel
import com.example.wprintapp.modules.printfee.`data`.model.ListtshcounterTwoRowModel
import com.example.wprintapp.modules.printfee.`data`.viewmodel.PrintFeeVM
import com.example.wprintapp.modules.profile.ui.ProfileActivity
import kotlin.Int
import kotlin.String
import kotlin.Unit

class PrintFeeActivity : BaseActivity<ActivityPrintFeeBinding>(R.layout.activity_print_fee) {
  private val viewModel: PrintFeeVM by viewModels<PrintFeeVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val listtshcounterAdapter =
    ListtshcounterAdapter(viewModel.listtshcounterList.value?:mutableListOf())
    binding.recyclerListtshcounter.adapter = listtshcounterAdapter
    listtshcounterAdapter.setOnItemClickListener(
    object : ListtshcounterAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListtshcounterRowModel) {
        onClickRecyclerListtshcounter(view, position, item)
      }
    }
    )
    viewModel.listtshcounterList.observe(this) {
      listtshcounterAdapter.updateData(it)
    }
    val listtshcounterTwoAdapter =
    ListtshcounterTwoAdapter(viewModel.listtshcounterTwoList.value?:mutableListOf())
    binding.recyclerListtshcounterTwo.adapter = listtshcounterTwoAdapter
    listtshcounterTwoAdapter.setOnItemClickListener(
    object : ListtshcounterTwoAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ListtshcounterTwoRowModel) {
        onClickRecyclerListtshcounterTwo(view, position, item)
      }
    }
    )
    viewModel.listtshcounterTwoList.observe(this) {
      listtshcounterTwoAdapter.updateData(it)
    }
    binding.printFeeVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnDone.setOnClickListener {
      val destIntent = ProfileActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerListtshcounter(
    view: View,
    position: Int,
    item: ListtshcounterRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerListtshcounterTwo(
    view: View,
    position: Int,
    item: ListtshcounterTwoRowModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "PRINT_FEE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PrintFeeActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
