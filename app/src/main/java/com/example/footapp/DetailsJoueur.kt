package com.example.footapp

import com.example.footapp.models.Joueur
import android.os.Bundle
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
import com.example.footapp.databinding.ActivityDetailsJoueurBinding
import com.example.footapp.viewmodel.JoueurViewModel

class DetailsJoueur : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDetailsJoueurBinding
    private  var  player_id  : Long = 0
    private lateinit var joueurViewModel : JoueurViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player_id = intent.getLongExtra("joueur",0)


        joueurViewModel = ViewModelProvider(this).get(JoueurViewModel::class.java)
        joueurViewModel.loadJoueurData(player_id)

        joueurViewModel.joueurData.observe(this, Observer {
            update(joueurViewModel.joueurData.value!!)

        })

        binding = ActivityDetailsJoueurBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_details_joueur)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->

          navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_details_joueur)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }




    fun update(joueur: Joueur) {

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val  player_name  =  findViewById<TextView>(R.id.player_name_stats)
        val player_number =  findViewById<TextView>(R.id.player_number_stats)
        val player_type =  findViewById<TextView>(R.id.player_type_stats)
        val player_image  =  findViewById<ImageView>(R.id.player_image_stats)
        val player_age_stats = findViewById<TextView>(R.id.player_age_stats)
        val player_goals = findViewById<TextView>(R.id.player_goals)
        val player_red_cards = findViewById<TextView>(R.id.player_red_cards)
        val player_yellow_cards = findViewById<TextView>(R.id.player_yellow_cards)

        val player_injured = findViewById<TextView>(R.id.player_injured)
        val player_assists  = findViewById<TextView>(R.id.player_assists)
        val player_duels_total = findViewById<TextView>(R.id.player_duels_total)


        player_assists.text = joueur.player_assists
        player_duels_total.text = joueur.player_duels_total
        player_injured.text = joueur.player_injured


        progressBar.isVisible = false
        player_yellow_cards.text = joueur.player_yellow_cards
        player_red_cards.text = joueur.player_red_cards
        player_goals.text = joueur.player_goals
        player_name.text = joueur.player_name
        player_age_stats.text = joueur.player_age
        val downloadImageTask = DownloadImageTask(player_image)
        downloadImageTask.execute(joueur.player_image)
        player_number.text = joueur.player_number
        player_type.text = joueur.player_type

        // Log.e("BONN", response.body()!![0].toString()  )
    }

}