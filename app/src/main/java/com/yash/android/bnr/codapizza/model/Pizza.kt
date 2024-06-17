package com.yash.android.bnr.codapizza.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pizza(
    val size: PizzaSize = PizzaSize.Small,
    val toppings: Map<Topping, ToppingPlacement> = emptyMap()
) : Parcelable {
    val price: Double
        get() = when(size) {
            PizzaSize.Small -> 7.99
            PizzaSize.Medium -> 9.99
            PizzaSize.Large -> 11.99
            PizzaSize.ExtraLarge -> 13.99
        } + toppings.asSequence()
            .sumOf { (_, toppingPlacement) ->
                when (toppingPlacement) {
                    ToppingPlacement.Left, ToppingPlacement.Right -> 0.5
                    ToppingPlacement.All -> 1.0
                }
            }

    fun withTopping(topping: Topping, toppingPlacement: ToppingPlacement?): Pizza {
        return copy(
            toppings = if (toppingPlacement == null) {
                toppings - topping
            } else {
                toppings + (topping to toppingPlacement)
            }
        )
    }

    fun withSize(size: PizzaSize): Pizza {
        return copy(size = size)
    }
}
