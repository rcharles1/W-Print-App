package com.example.wprintapp.modules.printfee.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.printfee.`data`.model.ListtshcounterRowModel
import com.example.wprintapp.modules.printfee.`data`.model.ListtshcounterTwoRowModel
import com.example.wprintapp.modules.printfee.`data`.model.PrintFeeModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class PrintFeeVM : ViewModel(), KoinComponent {
  val printFeeModel: MutableLiveData<PrintFeeModel> = MutableLiveData(PrintFeeModel())

  var navArguments: Bundle? = null

  val listtshcounterList: MutableLiveData<MutableList<ListtshcounterRowModel>> =
      MutableLiveData(mutableListOf())

  val listtshcounterTwoList: MutableLiveData<MutableList<ListtshcounterTwoRowModel>> =
      MutableLiveData(mutableListOf())
}
