package com.example.footapp.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "joueur_comments",
    indices = [Index("joueurId")],
    foreignKeys = [ForeignKey(entity = JoueurEntity::class,
        parentColumns = ["id"],
        childColumns = ["joueurId"],
        onDelete = ForeignKey.CASCADE)])

data class JoueurComments(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val joueurId: Long,
    val player_key: Long,
    val comments: String?,
    val date: String? = null
)
