package com.yash.android.bnr.codapizza.model

import androidx.annotation.StringRes
import com.yash.android.bnr.codapizza.R

enum class ToppingPlacement(@StringRes val label: Int) {
    Left(R.string.placement_left),
    Right(R.string.placement_right),
    All(R.string.placement_all)
}