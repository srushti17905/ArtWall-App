package com.example.wallpaper_app

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class Database(context: Context) : SQLiteOpenHelper(context, "mydb.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        val imageTable = "CREATE TABLE user (ID INTEGER Primary Key autoincrement , image Int UNIQUE) "
        db?.execSQL(imageTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(image: Int) {

        val insert = "INSERT INTO user (image) VALUES ('$image')"

        try {
            writableDatabase.execSQL(insert)
        } catch (e: Exception) {

            Log.d("===>", "insertData: ${e.localizedMessage}")

        }
    }

    fun selectData(image: Int): Cursor {

        val select = "SELECT * FROM user WHERE (image = '$image')"
        val cursor = readableDatabase.rawQuery(select, null)
        return cursor

    }

}