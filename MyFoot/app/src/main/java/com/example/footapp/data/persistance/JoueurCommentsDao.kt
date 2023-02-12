package com.example.footapp.data.persistance
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.footapp.data.JoueurComments


@Dao
interface JoueurCommentsDao {
    @Insert
    fun insert(joueurComments: JoueurComments)

    @Insert
    fun insertAll(vararg joueurComments: JoueurComments)

    @Update
    fun update(joueurComments: JoueurComments)

    @Query("SELECT * FROM joueur_comments")
    fun getAllPlayersDetail(): LiveData<List<JoueurComments>>

    @Query("SELECT * FROM joueur_comments WHERE player_key = :playerId")
    fun getPlayerDetailByPlayerId(playerId: Long): MutableList<JoueurComments>

    @Query("DELETE FROM joueur_comments WHERE id = :id")
    fun delete(id : Long)
}