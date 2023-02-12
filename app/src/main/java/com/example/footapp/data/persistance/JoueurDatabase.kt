package com.example.footapp.data.persistance;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.footapp.data.JoueurComments
import com.example.footapp.data.JoueurEntity
import java.time.LocalDate
import java.util.*

private const val DATABASE_NAME = "joueursapp.db"

@Database(entities = [JoueurEntity::class, JoueurComments::class], version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {
        abstract fun joueurDao(): JoueurDao
        abstract fun joueurDetailDao(): JoueurCommentsDao

        companion object {
                 private var instance: PlayerDatabase? = null

                fun getInstance(context: Context): PlayerDatabase {
                        if (instance == null) {
                                instance = Room.databaseBuilder(context, PlayerDatabase::class.java, DATABASE_NAME)

                                        .build()
                        }
                        return instance!!
                }

        }


}
