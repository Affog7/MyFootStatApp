package com.example.footapp

import com.example.footapp.models.Joueur
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class JoueursAdapter(val joueurs: MutableList<Joueur>) : RecyclerView.Adapter<JoueursHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JoueursHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.joueurs_card2,parent, false)
        return JoueursHolder(view)
    }

    override fun onBindViewHolder(holder: JoueursHolder, position: Int) {
        return holder.bindView(joueurs[position])
    }

    override fun getItemCount(): Int {
        return  joueurs.size
    }
}

class JoueursHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val  constraintLayout = itemView.findViewById<ConstraintLayout>(R.id.constraint_layout)


    private  val  player_name  = itemView.findViewById<TextView>(R.id.player_name)
    private  val player_number = itemView.findViewById<TextView>(R.id.player_number)
    private  val player_type = itemView.findViewById<TextView>(R.id.player_type)
    private val player_image  = itemView.findViewById<ImageView>(R.id.player_image)
    private val player_rating = itemView.findViewById<RatingBar>(R.id.player_rating)


    fun bindView(joueur : Joueur){
        player_name.text = joueur.player_name
        val downloadImageTask = DownloadImageTask(player_image)
        downloadImageTask.execute(joueur.player_image)
        player_number.text = joueur.player_number
        player_type.text = joueur.player_type
        player_rating.isEnabled = false




        if( joueur.player_rating != "" && joueur.player_rating != null)
            player_rating.rating =   joueur.player_rating!!.toFloat()  / 2

        constraintLayout.setOnClickListener {
            Toast.makeText(itemView.context, "i'm ${joueur.player_name}", Toast.LENGTH_SHORT).show()


            val intent = Intent(itemView.context, DetailsJoueur::class.java)


            intent.putExtra("joueur", joueur.player_id)

            itemView.context.startActivity(intent)

        }
    }
}