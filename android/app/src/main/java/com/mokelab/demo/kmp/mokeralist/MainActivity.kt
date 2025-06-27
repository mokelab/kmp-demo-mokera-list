package com.mokelab.demo.kmp.mokeralist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.mokelab.demo.kmp.mokeralist.core.design.component.Screen
import com.mokelab.demo.kmp.mokeralist.core.design.theme.KMPDemoMokeraListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KMPDemoMokeraListTheme {
                Screen(modifier = Modifier.fillMaxSize()) { innerPadding ->
                }
            }
        }
    }
}