package com.example.footapp.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "joueur_comments")

data class JoueurComments(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val player_key: Long,
    val comments: String?,
    val date: String? = null
)
