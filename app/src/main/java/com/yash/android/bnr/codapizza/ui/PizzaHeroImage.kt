package com.yash.android.bnr.codapizza.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yash.android.bnr.codapizza.R
import com.yash.android.bnr.codapizza.model.Pizza
import com.yash.android.bnr.codapizza.model.PizzaSize
import com.yash.android.bnr.codapizza.model.Topping
import com.yash.android.bnr.codapizza.model.ToppingPlacement

@Preview
@Composable
fun PizzaHeroImagePreview() {
    PizzaHeroImage(
        pizza = Pizza(
            size = PizzaSize.Medium,
            toppings = mapOf(
                Topping.Pepperoni to ToppingPlacement.All,
                Topping.Olive to ToppingPlacement.Left,
                Topping.Pineapple to ToppingPlacement.Right
            )
        )
    )
}

@Composable
fun PizzaHeroImage(
    pizza: Pizza,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = R.drawable.pizza_crust),
            contentDescription = stringResource(id = R.string.pizza_preview)
        )
        pizza.toppings.forEach { (topping, placement) ->
            Image(
                painter = painterResource(id = topping.pizzaOverlayImage),
                contentDescription = null,
                modifier = Modifier.focusable(false)
            )
        }
    }
}