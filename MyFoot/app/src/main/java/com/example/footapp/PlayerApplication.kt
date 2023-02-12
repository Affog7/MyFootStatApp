package com.example.footapp


import android.app.Application
import com.example.footapp.data.persistance.JoueurDatabase

class PlayerApplication : Application() {
     override fun onCreate() {
        super.onCreate()
        JoueurDatabase.initialize(this)
    }
}