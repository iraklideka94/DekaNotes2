package com.example.dekanotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.dekanotes.presentation.dashboard.DashboardScreen
import com.example.dekanotes.presentation.theme.DekaNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DekaNotesTheme {
                // A surface container using the 'background' color from the


                DashboardScreen()

            }
        }
    }
}

