package com.example.runningapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsSortedBySpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByDuration(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getAllRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT SUM(distanceInMeters) FROM RUNNING_TABLE")
    fun getTotalDistance(): LiveData<Int>

    @Query("SELECT SUM(timeInMillis) FROM RUNNING_TABLE")
    fun getTotalDuration(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM RUNNING_TABLE")
    fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT SUM(timeInMillis) FROM RUNNING_TABLE")
    fun getTotalTimeInMillis(): LiveData<Int>

    @Query("SELECT AVG(avgSpeedInKMH) FROM RUNNING_TABLE")
    fun getAvgSpeed(): LiveData<Float>




}