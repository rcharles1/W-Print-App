package com.example.wprintapp.modules.filepreview.ui

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.base.BaseActivity
import com.example.wprintapp.databinding.ActivityFilePreviewBinding
import com.example.wprintapp.modules.filepreview.data.viewmodel.FilePreviewVM
import com.example.wprintapp.modules.selectprinter.ui.SelectPrinterActivity
import com.github.barteksc.pdfviewer.PDFView

class FilePreviewActivity : BaseActivity<ActivityFilePreviewBinding>(R.layout.activity_file_preview) {
  private val viewModel: FilePreviewVM by viewModels()
  lateinit var pdfView: PDFView
  private val PDF_SELECTION_CODE = 100

// val imageUri = intent.getStringExtra("image_uri")
// Use the image URI to display the selected image

  override fun onInitialized() {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.filePreviewVM = viewModel

    pdfView = findViewById(R.id.pdfView)
    selectFromStorage()

  }

  private fun selectFromStorage() {
    val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
    browseStorage.type ="application/pdf"
    browseStorage.addCategory((Intent.CATEGORY_OPENABLE))
    startActivityForResult(Intent.createChooser(browseStorage,"Select PDF"),PDF_SELECTION_CODE)
  }

  fun showPdfFromUri(uri:Uri?){
    pdfView.fromUri(uri)
      .defaultPage(0)
      .spacing(10)
      .load()
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == PDF_SELECTION_CODE && resultCode == Activity.RESULT_OK && data != null){
      val selectedPdf = data.data
      showPdfFromUri(selectedPdf)

    }
  }

  override fun setUpClicks() {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnSelectPrinterOne.setOnClickListener {
      val destIntent = SelectPrinterActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FILE_PREVIEW_ACTIVITY"

  }
}
