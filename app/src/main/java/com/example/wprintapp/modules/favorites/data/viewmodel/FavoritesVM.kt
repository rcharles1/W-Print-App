package com.example.wprintapp.modules.favorites.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wprintapp.modules.favorites.`data`.model.FavoritesModel
import com.example.wprintapp.modules.favorites.`data`.model.FavoritesRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class FavoritesVM : ViewModel(), KoinComponent {
  val favoritesModel: MutableLiveData<FavoritesModel> = MutableLiveData(FavoritesModel())

  var navArguments: Bundle? = null

  val favoritesList: MutableLiveData<MutableList<FavoritesRowModel>> =
      MutableLiveData(mutableListOf())
}
