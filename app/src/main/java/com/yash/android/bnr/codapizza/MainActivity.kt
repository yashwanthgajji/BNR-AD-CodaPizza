package com.yash.android.bnr.codapizza

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.yash.android.bnr.codapizza.model.Topping
import com.yash.android.bnr.codapizza.model.ToppingPlacement
import com.yash.android.bnr.codapizza.ui.ToppingCell

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToppingCell(topping = Topping.Olive, toppingPlacement = ToppingPlacement.All) {

            }
        }
    }
}