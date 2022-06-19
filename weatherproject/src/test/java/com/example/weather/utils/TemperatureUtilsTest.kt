package com.example.weather.utils

import com.google.common.truth.Truth
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TemperatureUtilsTest {
    @Test
    fun `test convertTempCelsiusToFahrenheit when celsius is positive`() {
        // When celsius is positive
        val celsius = "36.68"
        val actualResult = TemperatureUtils.convertTempCelsiusToFahrenheit(celsius)
        // Expected Result is 98.02
        Truth.assertThat(actualResult).isEqualTo("98.02")

        // When celsius is positive
        val celsiusSecond = "7"
        val actualResultSecond = TemperatureUtils.convertTempCelsiusToFahrenheit(celsiusSecond)
        // Expected Result is 44.60
        Truth.assertThat(actualResultSecond).isEqualTo("44.60")
    }


    @Test
    fun `test convertTempCelsiusToFahrenheit when celsius is Negative`() {
        // When celsius is positive
        val celsius = "-36.68"
        val actualResult = TemperatureUtils.convertTempCelsiusToFahrenheit(celsius)
        // Expected Result is 34.02
        Truth.assertThat(actualResult).isEqualTo("-34.02")

        // When celsius is positive
        val celsiusSecond = "-7"
        val actualResultSecond = TemperatureUtils.convertTempCelsiusToFahrenheit(celsiusSecond)
        // Expected Result is 19.40
        Truth.assertThat(actualResultSecond).isEqualTo("19.40")
    }


    @Test
    fun `test convertTempCelsiusToFahrenheit when celsius is Zero`() {
        // When celsius is positive
        val celsius = "0"
        val actualResult = TemperatureUtils.convertTempCelsiusToFahrenheit(celsius)
        // Expected Result is 32.0
        Truth.assertThat(actualResult).isEqualTo("32.00")

    }
}