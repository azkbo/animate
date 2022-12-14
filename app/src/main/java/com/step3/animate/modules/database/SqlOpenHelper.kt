package com.step3.animate.modules.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Author: Meng
 * Date: 2022/08/30
 * Desc:
 */
class SqlOpenHelper(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ANIM)
        db.execSQL(SQL_CREATE_PHOTO)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ANIM)
        db.execSQL(SQL_DELETE_PHOTO)
        onCreate(db)
    }
    companion object {
        const val VERSION = 1
        const val NAME = "animate3.db"
    }
}