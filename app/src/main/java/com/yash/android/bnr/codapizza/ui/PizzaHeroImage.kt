package com.yash.android.bnr.codapizza.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            size = PizzaSize.ExtraLarge,
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
    Box(
        modifier = modifier
            .padding(when(pizza.size) {
                PizzaSize.ExtraLarge -> 16.dp
                PizzaSize.Large -> 32.dp
                PizzaSize.Medium -> 48.dp
                PizzaSize.Small -> 64.dp
            })
            .aspectRatio(1f)
    ) {
        Image(
            painter = painterResource(id = R.drawable.pizza_crust),
            contentDescription = stringResource(id = R.string.pizza_preview),
            modifier = Modifier.fillMaxSize()
        )
        pizza.toppings.forEach { (topping, placement) ->
            Image(
                painter = painterResource(id = topping.pizzaOverlayImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                alignment = when(placement) {
                    ToppingPlacement.Left -> Alignment.TopStart
                    ToppingPlacement.Right -> Alignment.TopEnd
                    ToppingPlacement.All -> Alignment.Center },
                modifier = Modifier
                    .focusable(false)
                    .aspectRatio(when(placement) {
                        ToppingPlacement.Left, ToppingPlacement.Right -> 0.5f
                        ToppingPlacement.All -> 1f
                    })
                    .align(when(placement) {
                        ToppingPlacement.Left -> Alignment.CenterStart
                        ToppingPlacement.Right -> Alignment.CenterEnd
                        ToppingPlacement.All -> Alignment.Center
                    })
            )
        }
    }
}