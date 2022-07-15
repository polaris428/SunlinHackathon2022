package com.example.sunlinhackathon2022.dict

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AnimalDTO::class], version=1)
abstract class AnimalDatabase : RoomDatabase() {
    abstract fun animalDao(): AnimalDao
}