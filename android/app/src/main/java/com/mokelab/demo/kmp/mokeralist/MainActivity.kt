package com.mokelab.demo.kmp.mokeralist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mokelab.demo.kmp.mokeralist.core.design.theme.KMPDemoMokeraListTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KMPDemoMokeraListTheme {
                MainApp()
            }
        }
    }
}