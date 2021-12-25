package com.example.presentation.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.presentation.util.TestCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.mockito.MockitoAnnotations

open class BaseViewModelTest {

    // sets the main dispatcher to testCoroutineDispatcher, It also creates testCoroutineScope to run our tests
    @ExperimentalCoroutinesApi
    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    // Executes each task synchronously using Architecture Components. (testing with LiveData)
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    open fun setup(){
        MockitoAnnotations.initMocks(this)
    }

    @After
    open fun clear() {}
}