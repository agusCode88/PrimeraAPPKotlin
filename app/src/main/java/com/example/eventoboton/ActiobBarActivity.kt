package com.example.eventoboton

import android.annotation.SuppressLint
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.Toolbar
import com.example.eventoboton.interfaces.IActionBarApp

open class ActionBarActivity : AppCompatActivity(), IActionBarApp {

    lateinit var _toolbar:Toolbar

    override fun loadActionBarInActivity(toolbar: Toolbar) {

        _toolbar = toolbar
        _toolbar.let {
            setSupportActionBar(toolbar)
        }
    }

    override fun loadButtonBackInScreen(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.appbar_menu, menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return true
    }

    override fun loadItemsOnMenuActionBar(toolbar: Toolbar) {
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.action_search -> {
                    searchInActionBar()
                    true
                }
                R.id.action_share -> {
                    // Compartir algo
                    shareInActionBar()
                    true
                }
                else -> false
            }

        }

    }

    override fun searchInActionBar() {
        TODO("Not yet implemented")
    }

    override fun shareInActionBar() {
        TODO("Not yet implemented")
    }

}