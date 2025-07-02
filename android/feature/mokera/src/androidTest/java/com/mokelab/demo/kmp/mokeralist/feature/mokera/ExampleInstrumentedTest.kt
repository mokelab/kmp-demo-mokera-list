package com.mokelab.demo.kmp.mokeralist.feature.mokera

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented kotlin, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under kotlin.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(
            "com.mokelab.demo.kmp.mokeralist.feature.mokera.kotlin",
            appContext.packageName
        )
    }
}