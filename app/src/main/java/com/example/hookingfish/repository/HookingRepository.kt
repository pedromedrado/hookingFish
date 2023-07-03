package com.example.hookingfish.repository

import android.content.ContentValues
import android.content.Context
import com.example.hookingfish.contants.DataBaseConstants
import com.example.hookingfish.model.Model

class HookingRepository(context: Context) {

    private val hookingDateBase = HookingDateBasee.HookingDataBase(context)


    companion object {

        private lateinit var repository: HookingRepository

        fun getInstance(context: Context): HookingRepository {

            if (!Companion::repository.isInitialized) {
                repository = HookingRepository(context)
            }
            return repository
        }
    }


    fun insert(data: Model): Boolean {

        return try {
            val db = hookingDateBase.writableDatabase
            val values = ContentValues()
            values.put(DataBaseConstants.Hooking.COLUMNS.ID, data.id)
            values.put(DataBaseConstants.Hooking.COLUMNS.NAME, data.name)
            values.put(DataBaseConstants.Hooking.COLUMNS.EMAIL, data.email)
            values.put(DataBaseConstants.Hooking.COLUMNS.PASSWORD, data.password)

            db.insert(DataBaseConstants.Hooking.TABLE_NAME, null, values)
            true

        } catch (e: Exception) {
            false
        }
    }
}