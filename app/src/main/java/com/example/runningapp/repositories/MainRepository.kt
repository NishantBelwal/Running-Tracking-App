package com.example.runningapp.repositories

import com.example.runningapp.db.Run
import com.example.runningapp.db.RunDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDAO: RunDAO
) {

    suspend fun insertRun(run:Run) = runDAO.insertRun(run)
    suspend fun deleteRun(run:Run) = runDAO.deleteRun(run)

    fun getAllRunsSortedByDate() = runDAO.getAllRunsSortedByDate()
    fun getAllRunsSortedByDistance() = runDAO.getAllRunsSortedByDistance()
    fun getAllRunsSortedBySpeed() = runDAO.getAllRunsSortedBySpeed()
    fun getAllRunsSortedByDuration() = runDAO.getAllRunsSortedByDuration()
    fun getAllRunsSortedByCaloriesBurned() = runDAO.getAllRunsSortedByCaloriesBurned()
    fun getAvgSpeed() = runDAO.getAvgSpeed()
    fun getTotalDistance() = runDAO.getTotalDistance()
    fun getTotalDuration() = runDAO.getTotalDuration()
    fun getTotalCaloriesBurned() = runDAO.getTotalCaloriesBurned()
    fun getTotalTime() = runDAO.getTotalTimeInMillis()
}