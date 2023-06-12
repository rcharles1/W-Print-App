package com.example.wprintapp.modules.jobstatusqueued.`data`.model

import com.example.wprintapp.R
import com.example.wprintapp.appcomponents.di.MyApp
import kotlin.String

data class JobStatusQueuedModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtQueued: String? = MyApp.getInstance().resources.getString(R.string.lbl_queued)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtYourprintjob: String? =
      MyApp.getInstance().resources.getString(R.string.msg_your_print_job)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrinter: String? = MyApp.getInstance().resources.getString(R.string.lbl_printer)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCanonPIXMA: String? = MyApp.getInstance().resources.getString(R.string.lbl_canon_pixma)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLocation: String? = MyApp.getInstance().resources.getString(R.string.lbl_location)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtArdhiUniversit: String? =
      MyApp.getInstance().resources.getString(R.string.msg_ardhi_universit)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtFileName: String? = MyApp.getInstance().resources.getString(R.string.lbl_file_name)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTestPagepdf: String? = MyApp.getInstance().resources.getString(R.string.lbl_test_page_pdf)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCANCEL: String? = MyApp.getInstance().resources.getString(R.string.lbl_cancel)

)
