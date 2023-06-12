package com.example.wprintapp.modules.home.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseFragment
import com.example.wprintapp.databinding.FragmentHomeBinding
import com.example.wprintapp.modules.filepreview.ui.FilePreviewActivity
import com.example.wprintapp.modules.home.data.viewmodel.HomeVM

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
  private val viewModel: HomeVM by viewModels()
  private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
  private var isReadPermissionGranted = false
  private var isMediaStoreGranted = false
  private val contentResolver = context?.contentResolver


  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  override fun onInitialized() {
    viewModel.navArguments = arguments
    binding.homeVM = viewModel

    permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions->

      isReadPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: isReadPermissionGranted
      isMediaStoreGranted = permissions[Manifest.permission.READ_MEDIA_IMAGES] ?: isReadPermissionGranted

    }
    requestPermission()
  }

  @RequiresApi(Build.VERSION_CODES.TIRAMISU)
  private fun requestPermission() {
    isReadPermissionGranted = ContextCompat.checkSelfPermission(requireContext(),
      Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED

    isMediaStoreGranted = ContextCompat.checkSelfPermission(requireContext(),
      Manifest.permission.READ_MEDIA_IMAGES
    ) == PackageManager.PERMISSION_GRANTED

    val permissionRequest : MutableList<String> = ArrayList()
    if (!isReadPermissionGranted){
      permissionRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
    }
    if (!isMediaStoreGranted){
      permissionRequest.add(Manifest.permission.READ_MEDIA_IMAGES)
    }

    if (permissionRequest.isNotEmpty()){
      permissionLauncher.launch(permissionRequest.toTypedArray())
    }
  }

  override fun setUpClicks() {

    // Create a callback to handle the result of the file picker activity
    val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
      // Handle the returned Uri
      if (uri != null) {
        // Get the file path from the Uri
        val filePath = getPathFromUri(uri)
        // Do something with the file path
        val i = Intent(activity, FilePreviewActivity::class.java)
         i.putExtra("filePath", filePath)
         activity?.startActivity(i)
      }
    }

    binding.linearColumnpictures.setOnClickListener {
      val intent = Intent(Intent.ACTION_PICK)
      intent.type = "image/*"
      getContent.launch("image/*")
    }

    binding.linearColumndocument.setOnClickListener {
      val i = Intent(activity, FilePreviewActivity::class.java)
      activity?.startActivity(i)
//        val mimeTypes = arrayOf(
//          "application/pdf",
//          "application/msword",
//          "application/vnd.ms-powerpoint",
//          "application/vnd.ms-excel",
//          "text/plain"
//        )
//        val intent = Intent(Intent.ACTION_GET_CONTENT)
//        intent.addCategory(Intent.CATEGORY_OPENABLE)
//        intent.type = if (mimeTypes.size == 1) mimeTypes[0] else "*/*"
//        if (mimeTypes.isNotEmpty()) {
//          intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
//          getContent.launch(mimeTypes.toString())
//        }
    }
    }

  // Helper function to get the file path from a Uri
  @SuppressLint("Range")
  private fun getPathFromUri(uri: Uri): String? {
    val cursor = contentResolver?.query(uri, arrayOf(MediaStore.Images.Media.DATA), null, null, null)
    cursor?.moveToFirst()
    val filePath = cursor?.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA))
    cursor?.close()
    return filePath
  }

  companion object {
    const val TAG: String = "HOME_FRAGMENT"


    fun getInstance(bundle: Bundle?): HomeFragment {
      val fragment = HomeFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
