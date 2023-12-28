package com.asadullo.authorsapp.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.asadullo.authorsapp.Models.SaveAuthor

@Dao
interface DbINterface {
    @Insert
    fun add(author:SaveAuthor)

    @Query("select * from saveauthor")
    fun get():List<SaveAuthor>

    @Delete
    fun delet(author: SaveAuthor)
}