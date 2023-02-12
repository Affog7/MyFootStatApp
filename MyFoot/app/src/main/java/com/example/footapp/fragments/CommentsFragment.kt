package com.example.footapp.fragments

import NotificationHelper
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.footapp.R
import com.example.footapp.databinding.FragmentSecondBinding
import com.example.footapp.utils.JoueurObject
import com.example.footapp.viewmodel.JoueurViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class  CommentsFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var joueurViewModel : JoueurViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        activity?.setTitle("Nouveau Coments< ${JoueurObject.nomjoueur} >");
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nom = view.findViewById<TextView>(R.id.playerNameComment)
        val id = JoueurObject.idJoueur
        nom.text = JoueurObject.nomjoueur

        joueurViewModel = ViewModelProvider(this).get(JoueurViewModel::class.java)

        binding.buttonSecond.setOnClickListener {
            val commentaire = view.findViewById<TextView>(R.id.commentsEnter)

            joueurViewModel.insertNewComment(id,commentaire.text.toString())
            Toast.makeText(view.context, "Commentaire ajouté avec succès", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    override fun onResume() {
        super.onResume()
    }
}