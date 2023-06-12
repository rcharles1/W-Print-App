package com.example.wprintapp.modules.favorites.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class FavoritesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtFavoritePrinte: String? =
      MyApp.getInstance().resources.getString(R.string.msg_favorite_printe)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtSearchresults: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_search_results)

)
