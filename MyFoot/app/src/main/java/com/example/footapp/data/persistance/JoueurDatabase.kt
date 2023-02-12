package com.example.footapp.data.persistance

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.footapp.PlayerApplication
import com.example.footapp.data.JoueurComments
import com.example.footapp.data.JoueurEntity

private const val JOUEUR_DB_FILENAME = "joueurs_1.db"

@Database(entities = [JoueurEntity::class,JoueurComments::class], version = 2)
abstract class JoueurDatabase : RoomDatabase() {

        abstract fun joueurDAO(): JoueurDao
        abstract  fun commentsDAO() : JoueurCommentsDao

        companion object {
                private lateinit var application : Application

                @Volatile
                private var instance: JoueurDatabase? = null

                fun getInstance(): JoueurDatabase {
                        if (::application.isInitialized) {
                                if (instance == null)
                                        synchronized(this) {
                                                if (instance == null) {
                                                        instance = Room.databaseBuilder(
                                                                application.applicationContext,
                                                                JoueurDatabase::class.java,
                                                                JOUEUR_DB_FILENAME
                                                        )
                                                                .allowMainThreadQueries()
                                                                .build()

                                                        instance?.joueurDAO()?.let {
                                                                if (it.getAllPlayers().isEmpty()) emptyDatabaseStub(it)
                                                        }

                                                        instance?.commentsDAO()?.let {
                                                                if (it.getAllPlayersDetail() ==null)
                                                                        emptyDatabaseStubComments(it)
                                                        }

                                                }
                                        }
                                return instance!!
                        } else
                                throw RuntimeException("the database must be first initialized")
                }
                private fun emptyDatabaseStubComments(joueurDAO: JoueurCommentsDao) = with(joueurDAO) {



                        insert(JoueurComments(0, 1, "12/02/2022"),)
                        insert(JoueurComments(0, 2, "12/03/2022"))
                        insert(JoueurComments(0, 3, "09/12/2021"))


                }


                @Synchronized
                fun initialize(app: PlayerApplication) {
                        if (::application.isInitialized)
                                throw RuntimeException("the database must not be initialized twice")

                        application = app
                }


                private fun emptyDatabaseStub(joueurDAO: JoueurDao) = with(joueurDAO) {

                                insert(JoueurEntity(0, 1, "Player 1"))
                                 insert(JoueurEntity(0, 2, "Player 2"))
                                insert(JoueurEntity(0, 3, "Player 3"))


                }
        }
}
