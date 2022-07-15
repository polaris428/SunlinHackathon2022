package com.example.sunlinhackathon2022.dict

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AnimalDTO(
    @PrimaryKey val id: Int
)
