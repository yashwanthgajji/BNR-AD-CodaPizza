package com.yash.android.bnr.codapizza.model

import androidx.annotation.StringRes
import com.yash.android.bnr.codapizza.R

enum class PizzaSize(@StringRes val size: Int) {
    Small(R.string.size_small),
    Medium(R.string.size_medium),
    Large(R.string.size_large),
    ExtraLarge(R.string.size_extra_large)
}