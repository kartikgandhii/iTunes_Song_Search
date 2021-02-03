package com.example.itunessongsearch.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.itunessongsearch.ItunesResponse


@Dao
interface ITunesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert() {

    }
}