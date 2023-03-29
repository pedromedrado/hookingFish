package com.example.hookingfish.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.hookingfish.contants.DataBaseConstants

class HookingDateBasee {


    class HookingDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

        companion object {
            private const val NAME = "HookingDB"
            private const val VERSION = 2

            private const val SQL_crate_DB =
                "CREATE TABLE ${DataBaseConstants.Hooking.TABLE_NAME}(" +
                        "${DataBaseConstants.Hooking.COLUMNS.ID} INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "${DataBaseConstants.Hooking.COLUMNS.NAME} TEXT," +
                        "${DataBaseConstants.Hooking.COLUMNS.EMAIL} TEXT," +
                        "${DataBaseConstants.Hooking.COLUMNS.PASSWORD} TEXT)"
        }


        override fun onCreate(db: SQLiteDatabase) {

            db.execSQL(SQL_crate_DB)

        }

        override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {


        }


    }
}