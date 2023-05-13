package com.example.eventoboton.interfaces

import androidx.appcompat.widget.Toolbar

interface IActionBarApp {

    fun loadActionBarInActivity(toolbar: Toolbar)
    fun loadButtonBackInScreen(value:Boolean)
    fun loadItemsOnMenuActionBar(toolbar: Toolbar)
    fun searchInActionBar()
    fun shareInActionBar()

}