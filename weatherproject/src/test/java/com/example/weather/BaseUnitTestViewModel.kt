package com.example.weather

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.Rule

open class BaseUnitTestViewModel {
    // Using this rule for tests that use Architecture Components.
    @get:Rule
    var rule = InstantTaskExecutorRule()

    // Using this rule to host test containing coroutines
    @ExperimentalCoroutinesApi
    @get:Rule
    val coRoutineDispatcherRule = CoroutineDispatcherRule()

   @ExperimentalCoroutinesApi
   val testCouroutineScope =   TestCoroutineScope()
}