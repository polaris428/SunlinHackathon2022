package com.example.sunlinhackathon2022.dict

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnimalDao {
    @Query("SELECT * from AnimalDTO")
    fun getAll(): List<AnimalDTO>

    @Insert
    fun insertItem(animal: AnimalDTO)
}