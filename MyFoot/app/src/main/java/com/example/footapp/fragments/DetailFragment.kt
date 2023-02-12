package com.example.footapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.footapp.DownloadImageTask
import com.example.footapp.R
import com.example.footapp.adapter.CommentsAdapter
import com.example.footapp.databinding.FragmentFirstBinding
import com.example.footapp.models.Joueur
import com.example.footapp.utils.JoueurObject
import com.example.footapp.viewmodel.JoueurViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DetailFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private  var  player_id  : Long = 0
    private lateinit var joueurViewModel : JoueurViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        joueurViewModel = ViewModelProvider(this).get(JoueurViewModel::class.java)
        player_id = JoueurObject.idJoueur

        joueurViewModel.loadJoueurData(player_id)

        joueurViewModel.joueurData.observe(viewLifecycleOwner, Observer {
            update(joueurViewModel.joueurData.value!!,view)

        })

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewComments)
        if (recyclerView != null) {
            joueurViewModel.loadCommentsFromDBById(player_id).observe(viewLifecycleOwner, Observer { joueurs ->
                recyclerView.apply {
                    layoutManager =  LinearLayoutManager(view.context)

                    adapter = CommentsAdapter(joueurViewModel.joueursComments.value!!)
                }
            })
            val total_comments = view.findViewById<TextView>(R.id.total_comments)
                total_comments.text = joueurViewModel.joueursComments.value!!.size.toString()
        } else {
            Log.e("MainActivity", "recyclerView is null")
        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun update(joueur: Joueur, view: View) {



        val progressBar = view.findViewById<ProgressBar>(R.id. progressBar)
        val  player_name  =  view.findViewById<TextView>(R.id.player_name_stats)
        val player_number = view. findViewById<TextView>(R.id.player_number_stats)
        val player_type =  view.findViewById<TextView>(R.id.player_type_stats)
        val player_image  =  view.findViewById<ImageView>(R.id.player_image_stats)
        val player_age_stats = view.findViewById<TextView>(R.id.player_age_stats)
        val player_goals = view.findViewById<TextView>(R.id.player_goals)
        val player_red_cards = view.findViewById<TextView>(R.id.player_red_cards)
        val player_yellow_cards = view.findViewById<TextView>(R.id.player_yellow_cards)

        val player_injured = view.findViewById<TextView>(R.id.player_injured)
        val player_assists  = view.findViewById<TextView>(R.id.player_assists)
        val player_duels_total = view.findViewById<TextView>(R.id.player_duels_total)


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
    override fun onResume() {
        super.onResume()

    }

}