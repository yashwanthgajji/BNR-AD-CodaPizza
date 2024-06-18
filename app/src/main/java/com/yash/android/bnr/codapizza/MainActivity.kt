package com.yash.android.bnr.codapizza

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.yash.android.bnr.codapizza.ui.AppTheme
import com.yash.android.bnr.codapizza.ui.PizzaBuilderScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PizzaBuilderScreen()
            }
        }
    }
}