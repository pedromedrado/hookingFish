package com.example.hookingfish.contants

import android.provider.BaseColumns

class DataBaseConstants private constructor() {


    object Hooking {
        const val TABLE_NAME = "HOOKING1"

        object COLUMNS : BaseColumns {
            const val ID = "id"
            const val NAME = "name"
            const val EMAIL = "email"
            const val PASSWORD = "password"


        }



    }


}