package com.example.wprintapp.modules.favorites.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseFragment
import com.example.wprintapp.databinding.FragmentFavoritesBinding
import com.example.wprintapp.modules.favorites.`data`.model.FavoritesRowModel
import com.example.wprintapp.modules.favorites.`data`.viewmodel.FavoritesVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>(R.layout.fragment_favorites) {
  private val viewModel: FavoritesVM by viewModels<FavoritesVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    val favoritesAdapter = FavoritesAdapter(viewModel.favoritesList.value?:mutableListOf())
    binding.recyclerFavorites.adapter = favoritesAdapter
    favoritesAdapter.setOnItemClickListener(
    object : FavoritesAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : FavoritesRowModel) {
        onClickRecyclerFavorites(view, position, item)
      }
    }
    )
    viewModel.favoritesList.observe(requireActivity()) {
      favoritesAdapter.updateData(it)
    }
    binding.favoritesVM = viewModel
    setUpSearchViewAdvancedsearchListener()
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerFavorites(
    view: View,
    position: Int,
    item: FavoritesRowModel
  ): Unit {
    when(view.id) {
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

    companion object {
      const val TAG: String = "FAVORITES_FRAGMENT"


      fun getInstance(bundle: Bundle?): FavoritesFragment {
        val fragment = FavoritesFragment()
        fragment.arguments = bundle
        return fragment
      }
    }
  }
