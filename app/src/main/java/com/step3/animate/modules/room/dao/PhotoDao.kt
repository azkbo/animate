package com.step3.animate.modules.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.step3.animate.modules.room.entity.Photo

/**
 * Author: Meng
 * Date: 2022/08/30
 * Desc:
 */

@Dao
interface PhotoDao {
    @Query("SELECT * FROM photo ORDER BY id ASC")
    fun getAll(): List<Photo>

    @Query("SELECT * FROM photo WHERE id IN (:id)")
    fun findById(id: Int): Photo

    @Query("SELECT * FROM photo WHERE aid IN (:aid)")
    fun findByAnimId(aid: Int): List<Photo>

    @Insert
    fun insert(photo: Photo)

    @Delete
    fun delete(photo: Photo)
}