package com.example.footapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "joueurs")
    data class JoueurEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val player_key: Long,
        val name: String?
    )
/*
const val NEW_DOG_ID = 0L

@Entity(tableName = "dogs")
data class Dog(var name: String = "",
               var breed: String = "",
               var gender: Gender = Gender.UNKNOWN,
               var weight: Float = 0f,
               var aggressiveness: Int = 0,
               var owner: String? = null,
               var admissionDate: Date? = null,
               @PrimaryKey(autoGenerate = true) val id: Long = NEW_DOG_ID) {

    enum class Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }*/