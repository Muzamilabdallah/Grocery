package com.example.grocery.ui.theme.screen.setting;

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThemeViewModel : ViewModel() {
    private  var _isDark =MutableLiveData(false)
     val isDark:LiveData<Boolean> = _isDark

    fun onThemeChanged(dark: Boolean) {
        _isDark.value = dark

    }

}


