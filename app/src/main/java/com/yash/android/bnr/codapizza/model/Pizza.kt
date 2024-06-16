package com.yash.android.bnr.codapizza.model

data class Pizza(val toppings: Map<Topping, ToppingPlacement> = emptyMap()) {
    fun withTopping(topping: Topping, toppingPlacement: ToppingPlacement?): Pizza {
        return copy(
            toppings = if (toppingPlacement == null) {
                toppings - topping
            } else {
                toppings + (topping to toppingPlacement)
            }
        )
    }
}
