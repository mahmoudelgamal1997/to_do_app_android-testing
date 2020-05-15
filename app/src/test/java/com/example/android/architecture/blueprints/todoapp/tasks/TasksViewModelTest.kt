package com.example.android.architecture.blueprints.todoapp.tasks

import android.app.Application
import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.core.Is.`is`
import org.hamcrest.core.IsNull.nullValue
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.AdditionalMatchers.not
import org.robolectric.annotation.Config
import java.util.*
@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{
    // to make code run async and run in one thread
    @get:Rule
    var instantTaskExecutorRule =InstantTaskExecutorRule()

    lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupTaskViewmodel(){
        tasksViewModel= TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun addNewTask_Event() {


        //when adding new Task
        tasksViewModel.addNewTask()
        //then the new Task Event happen
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled(),(not(nullValue())))


    }


    @Test
    fun setFilter_addViewVisible(){

        //when
        val addnewVisible = tasksViewModel.setFiltering(TasksFilterType.ACTIVE_TASKS)
        //then
        assertThat(tasksViewModel.tasksAddViewVisible.getOrAwaitValue(),`is`(false))
    }




}