package com.example.footapp.data.persistance

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.footapp.data.JoueurEntity

@Dao
interface JoueurDao {
    @Insert
    fun insert(joueur: JoueurEntity)

    @Insert
    fun insertAll(vararg joueurs: JoueurEntity)

    @Update
    fun update(joueur: JoueurEntity)

    @Query("SELECT * FROM joueurs")
    fun getAllPlayers(): List<JoueurEntity>

    @Query("SELECT * FROM joueurs WHERE id = :playerId")
    fun getPlayerById(playerId: Long): JoueurEntity

    @Query("DELETE FROM joueurs")
    fun deleteAllPlayers()

    @Query("DELETE FROM joueurs WHERE id = :joueur")
    fun delete(joueur: Long)
}
