package com.example.wprintapp.modules.history.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.history.`data`.model.HistoryModel
import com.example.wprintapp.modules.history.`data`.model.HistoryRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class HistoryVM : ViewModel(), KoinComponent {
  val historyModel: MutableLiveData<HistoryModel> = MutableLiveData(HistoryModel())

  var navArguments: Bundle? = null

  val historyList: MutableLiveData<MutableList<HistoryRowModel>> = MutableLiveData(mutableListOf())
}
