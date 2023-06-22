package com.example.wprintapp.modules.printoptions.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityPrintOptionsBinding
import com.example.wprintapp.modules.invoice.ui.InvoiceActivity
import com.example.wprintapp.modules.printoptions.`data`.viewmodel.PrintOptionsVM
import kotlin.String
import kotlin.Unit

class PrintOptionsActivity :
    BaseActivity<ActivityPrintOptionsBinding>(R.layout.activity_print_options) {
  private val viewModel: PrintOptionsVM by viewModels()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.printOptionsVM = viewModel

    val items = resources.getStringArray(R.array.orientation)
    val item = resources.getStringArray(R.array.paper_size)
    val i = resources.getStringArray(R.array.color)


    val arrayAdapter = ArrayAdapter(this,R.layout.drop_down_menu, items)
    binding.autoComplete.setAdapter(arrayAdapter)

    val arrayAdapter2 = ArrayAdapter(this,R.layout.drop_down_menu,item)
    binding.autoComplete2.setAdapter(arrayAdapter2)

    val arrayAdapter3 = ArrayAdapter(this, R.layout.drop_down_menu,i)
    binding.autoComplete3.setAdapter(arrayAdapter3)

  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnSavePrintOptions.setOnClickListener {
      val destIntent = InvoiceActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "PRINT_OPTIONS_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, PrintOptionsActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
