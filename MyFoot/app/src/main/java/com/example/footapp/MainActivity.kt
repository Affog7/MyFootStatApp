package com.example.footapp

import NotificationHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
 import com.example.footapp.data.persistance.JoueurDatabase
 import com.example.footapp.viewmodel.JoueurViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import java.lang.Thread.sleep

class MainActivity : AppCompatActivity() {

    private lateinit var joueurViewModel : JoueurViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

val ctx = this
        runBlocking {
            joueurViewModel = ViewModelProvider(ctx).get(JoueurViewModel::class.java)
          async {  joueurViewModel.loadAllJoueurs() }
        sleep(1200)
        }
// Pour utiliser dans un autre endroit de l'application
     //   NotificationHelper(this).showNotification("Titre", "Message")

       val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        joueurViewModel.joueursData.observe(this, Observer { joueurs ->
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = JoueursAdapter(joueurViewModel.joueursData.value!!)
            }
         })





    }
}