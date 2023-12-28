package com.asadullo.authorsapp.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.asadullo.authorsapp.Models.SaveAuthor

@Database(entities = [SaveAuthor::class], version = 1)
abstract class Dbhelper:RoomDatabase() {
    abstract fun dao():DbINterface

    companion object{
        var instens:Dbhelper? = null

        @Synchronized
        fun getIns(context: Context):Dbhelper{
            if (instens == null){
                instens = Room.databaseBuilder(
                    context,
                    Dbhelper::class.java,
                    "my_db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instens!!
        }
    }
}