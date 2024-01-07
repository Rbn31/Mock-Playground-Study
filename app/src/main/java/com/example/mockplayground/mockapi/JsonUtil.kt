package com.example.mockplayground.mockapi

import android.content.Context
import com.google.gson.Gson

object JsonUtil {
    inline fun <reified T>getJsonDatafromAsset(context: Context, fileName: String): T? {

        val jsonString: String
        return try {
            jsonString = context.assets.open(fileName).bufferedReader().use{ it.readText()}

            Gson().fromJson(jsonString, T::class.java)
        }catch (ioException: Exception) {
            ioException.printStackTrace()
            null
        }
    }

}