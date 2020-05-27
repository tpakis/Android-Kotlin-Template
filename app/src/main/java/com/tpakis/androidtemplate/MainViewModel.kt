package com.tpakis.androidtemplate
/* ktlint-disable */
import androidx.lifecycle.ViewModel
import com.tpakis.core.annotations.ApiUrl
import javax.inject.Inject

class MainViewModel @Inject constructor(@ApiUrl private val url: String) : ViewModel() {

    fun getApiUrl(): String = url
}
