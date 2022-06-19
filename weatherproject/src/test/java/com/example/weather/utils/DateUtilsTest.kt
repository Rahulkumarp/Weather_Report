package com.example.weather.utils

import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class DateUtilsTest
{

    @Test
    fun `test getDateFromTimeStamp when timeStamp is not empty`()
    {
       // when timeStamp is not empty
        val timeStamp = 1654948800L
        val actualResult = DateUtils.getDateFromTimeStamp(timeStamp)
        // Expected Result is 11-Jun-2022
        Truth.assertThat(actualResult).isEqualTo("11-Jun-2022")

        // when timeStamp is not empty
        val timeStampSecond = 1655035200L
        val actualResultSecond = DateUtils.getDateFromTimeStamp(timeStampSecond)
        // Expected Result is 11-Jun-2022
        Truth.assertThat(actualResultSecond).isEqualTo("12-Jun-2022")
    }


    @Test
    fun `test getDateFromTimeStamp when timeStamp is ZERO`()
    {
        // when timeStamp is "0"
        val timeStamp = 0L
        val actualResult = DateUtils.getDateFromTimeStamp(timeStamp)
        // Expected Result is 11-Jun-2022
        Truth.assertThat(actualResult).isEqualTo("01-Jan-1970")

    }

    @Test
    fun `test getDateFromTimeStamp when timeStamp is Negative`()
    {
        // when timeStamp is negative
        val timeStamp = -1655035200L
        val actualResult = DateUtils.getDateFromTimeStamp(timeStamp)
        // Expected Result is 11-Jun-2022
        Truth.assertThat(actualResult).isEqualTo("22-Jul-1917")

    }

}