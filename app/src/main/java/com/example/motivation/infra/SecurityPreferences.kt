package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences


/**
 * Uses SharedPreferences for small data
 * that will have little change.
 */
class SecurityPreferences(context: Context) {

    /**
     * Starting the sharedPreferences
     */
    private val mSharedPreferences = context.getSharedPreferences("motivation", Context.MODE_PRIVATE)
    //the name in the context, can be anything


    /**
     * Function to save the value
     */
    fun storeString(key:String, value: String){
        mSharedPreferences.edit().putString(key, value).apply()

    }

    /**
     * Function to get the value
     */

    fun getString(key:String): String{
        return mSharedPreferences.getString(key, "") ?: ""

    }

}