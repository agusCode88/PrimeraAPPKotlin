package com.example.eventoboton

import android.annotation.SuppressLint
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.widget.Toolbar
import com.example.eventoboton.interfaces.IActionBarApp

class ActionBarActivity : AppCompatActivity(),IActionBarApp{

    protected var _toolbar: Toolbar? = null


    override fun loadActionBarInActivity(toolbar: Toolbar) {
        this._toolbar = toolbar

        // si no es nula es la copia de la variable, si no, no hace nada, let es usado para objetos
        _toolbar.let {
            setSupportActionBar(this._toolbar)
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
        //return super.onCreateOptionsMenu(menu)
    }

    override fun loadItemsOnMenuActionBar(toolbar: Toolbar) {
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_search -> {
                    // hacer la busqueda
                    true
                }
                R.id.action_share -> {
                    // compartir algo
                    true
                }

                else -> false
            }
        }
    }




}