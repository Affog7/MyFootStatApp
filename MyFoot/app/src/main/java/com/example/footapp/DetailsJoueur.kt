package com.example.footapp

import com.example.footapp.models.Joueur
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footapp.adapter.CommentsAdapter
import com.example.footapp.data.persistance.JoueurDatabase
import com.example.footapp.databinding.ActivityDetailsJoueurBinding
import com.example.footapp.utils.JoueurObject
import com.example.footapp.viewmodel.JoueurViewModel

class DetailsJoueur : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDetailsJoueurBinding
    private  var  player_id  : Long = 0
    private lateinit var joueurViewModel : JoueurViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityDetailsJoueurBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_details_joueur)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.Ajout.setOnClickListener { view ->

            JoueurObject.nomjoueur = findViewById<TextView>(R.id.player_name_stats).text.toString()

          navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }





    }



    public override fun onResume() {

        super.onResume()



    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_details_joueur)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }







    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }

}