package com.example.footapp.repository

import androidx.lifecycle.LiveData
import com.example.footapp.data.JoueurComments
import com.example.footapp.data.JoueurEntity
import com.example.footapp.data.persistance.JoueurCommentsDao
import com.example.footapp.data.persistance.JoueurDao

class CommentsRepository(private val commentsDAO : JoueurCommentsDao) {

    fun getCommentById(key : Long): MutableList<JoueurComments> {
        return commentsDAO.getPlayerDetailByPlayerId(key)
    }

     fun insertComment(joueurComments: JoueurComments) {
        commentsDAO.insert(joueurComments)
    }

     fun deleteComment(id: Long) {
        commentsDAO.delete(id)
    }


}
