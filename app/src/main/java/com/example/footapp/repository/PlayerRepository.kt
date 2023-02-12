package com.example.footapp.repository

import androidx.lifecycle.LiveData
import com.example.footapp.data.JoueurEntity
import com.example.footapp.data.persistance.JoueurDao
import kotlinx.coroutines.Dispatchers

class PlayerRepository(private val playerDao: JoueurDao) {

    fun getPlayers(): LiveData<List<JoueurEntity>> {
        return playerDao.getAllPlayers()
    }

    suspend fun insertUser(joueurEntity: JoueurEntity) {
        playerDao.insert(joueurEntity)
    }

    suspend fun deleteUser(joueurEntity: JoueurEntity) {
        playerDao.delete(joueurEntity.id)
    }


}


