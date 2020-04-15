package com.github.lion4ik.networkflow.sample

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.lion4ik.networkflow.NetworkFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val networkFlowChecker = NetworkFlow()

    fun startNetworkObserving(appContext: Context) {
        viewModelScope.launch {
            networkFlowChecker.networkState(appContext)
                .collect {
                Log.d("DEBUG", "value = $it")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}