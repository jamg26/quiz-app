package com.jamg.quizapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "jamg"
val TABLE_NAME = "score"
val COL_ID = "id"
val COL_SCORE = "score"

class DatabaseHandler (private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY, $COL_SCORE INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    fun insertData(score: Score) {
        val db = this.writableDatabase
        var content = ContentValues()
        content.put(COL_ID, 0)
        content.put(COL_SCORE, score.score)
        var res = db.insert(TABLE_NAME, null, content)

        if(res == (-1).toLong()){
            Toast.makeText(context, "Failed", Toast.LENGTH_LONG).show()
        } else {
            //Toast.makeText(context, "Success", Toast.LENGTH_LONG).show()
        }
    }

    fun readData() : MutableList<Score> {
        var list: MutableList<Score> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE ID=0"
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()) {
            do {
                var sc = Score()
                sc.id = result.getString(0).toInt()
                sc.score = result.getString(1).toInt()
                list.add(sc)
            } while (result.moveToNext())
        }

        result.close()
        db.close()
        return list
    }

    fun updateData(){
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE ID=0"
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()) {
            do {
                var content = ContentValues()
                content.put(COL_SCORE, result.getInt(result.getColumnIndex(COL_SCORE)) + 1)
                db.update(TABLE_NAME, content, "$COL_ID = ?", arrayOf(result.getString(result.getColumnIndex(
                    COL_ID))))
                //Toast.makeText(context, "Updated", Toast.LENGTH_LONG).show()
            } while (result.moveToNext())
        }

        result.close()
        db.close()
    }
}