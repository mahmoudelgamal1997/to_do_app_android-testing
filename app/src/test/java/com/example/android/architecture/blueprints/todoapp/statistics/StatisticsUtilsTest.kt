package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest{
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero() {
        // Create an active task
        val task = listOf<Task>(Task("sport","go gym",false))
        // Call your function
        val result = getActiveAndCompletedStats(task)

        // Check the result
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.activeTasksPercent, `is`(100f))
    }
    @Test
    fun getActiveAndCompletedStats_noCompleted_null_or_emputy_returnsHundredZero() {
        // Create an active task
        val task = emptyList<Task>()
        // Call your function
        val result = getActiveAndCompletedStats(task)

        // Check the result
        assertEquals(result.completedTasksPercent,0f)
        assertEquals(result.activeTasksPercent,0f)
    }

    @Test
    fun getActiveAndCompletedStats_return_Fourty_sexity() {
        // Create an active task
        val task = listOf<Task>(
                Task("sport","go gym",true)  ,
                Task("sport","go gym",true),
                Task("sport","go gym",true),
                Task("sport","go gym",false),
                Task("sport","go gym",false)
        )
        // Call your function
        val result = getActiveAndCompletedStats(task)

        // Check the result
        assertEquals(result.completedTasksPercent,60f)
        assertEquals(result.activeTasksPercent,40f)
    }

    @Test
    fun getActiveAndCompletedStats_equal_null_return_zero() {
        // When there's an error loading stats
        val task = null
        // Call your function
        val result = getActiveAndCompletedStats(task)

        // Check the result
        assertEquals(result.completedTasksPercent,0f)
        assertEquals(result.activeTasksPercent,0f)
    }

    @Test
    fun getActiveAndCompletedStats_equal_emputy_return_zero() {
        // When list is emputy

        // Call your function
        val result = getActiveAndCompletedStats(emptyList())

        // Check the result
        assertEquals(result.completedTasksPercent,0f)
        assertEquals(result.activeTasksPercent,0f)
    }



}