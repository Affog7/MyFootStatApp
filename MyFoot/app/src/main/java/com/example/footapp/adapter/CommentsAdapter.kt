package com.example.footapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.footapp.DetailsJoueur
import com.example.footapp.R
import com.example.footapp.data.JoueurComments
import com.example.footapp.viewmodel.JoueurViewModel

class CommentsAdapter(val joueurs: MutableList<JoueurComments>) : RecyclerView.Adapter<CommentsHolder>() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.comments,parent, false)
         return CommentsHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsHolder, position: Int) {
        return holder.bindView(joueurs[position],joueurs)
    }

    override fun getItemCount(): Int {

        return  joueurs.size
    }
}

class CommentsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


val but = itemView.findViewById<ImageButton>(R.id.delete_button)

    private  val  comments_text  = itemView.findViewById<TextView>(R.id.comments)
    private  val date = itemView.findViewById<TextView>(R.id.comments_date)

    private  val recy = itemView.findViewById<TextView>(R.id.recyclerViewComments)
    private  val total = itemView.findViewById<TextView>(R.id.total_comments)



 fun bindView(commt: JoueurComments, joueurs: MutableList<JoueurComments>){

     comments_text.text = commt.comments
     date.text = commt.date
     but.setOnClickListener {

    JoueurViewModel().deleteComment(commt.id)
         recy.invalidate()
         total.invalidate()
         DetailsJoueur().onResume()
}



    }



}