package com.yash.android.bnr.codapizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yash.android.bnr.codapizza.model.Topping
import com.yash.android.bnr.codapizza.model.ToppingPlacement


@Preview
@Composable
private fun ToppingCellPreview() {
    ToppingCell(
        Topping.Basil,
        ToppingPlacement.Left,
        onClickTopping = {}
    )
}

@Composable
public fun ToppingCell(
    topping: Topping,
    toppingPlacement: ToppingPlacement,
    onClickTopping: () -> Unit
    ) {
    Row {
        Checkbox(checked = true, onCheckedChange = { /* TODO */ })
        Column {
            Text(text = stringResource(id = topping.toppingName))
            Text(text = toppingPlacement.label.toString())
        }
    }
}