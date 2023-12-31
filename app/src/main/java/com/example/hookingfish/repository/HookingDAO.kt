package com.example.hookingfish.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.motivation1.model.GuestModel

@Dao
interface HokingDAO {
    @Insert
    fun insert(guest: GuestModel) : Long
    @Update
    fun update(guest: GuestModel): Int
    @Delete
    fun delete(guest: GuestModel)

    @Query("SELECT * FROM Guest where id  = :id")
    fun get(id: Int) :GuestModel

    @Query("SELECT * FROM Guest")
    fun getAll() : List<GuestModel>

    @Query("SELECT * FROM Guest where presence = 1")
    fun getPresent() : List<GuestModel>

    @Query("SELECT * FROM Guest where presence = 0")
    fun getAbsent() : List<GuestModel>
}