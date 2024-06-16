package com.yash.android.bnr.codapizza.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.yash.android.bnr.codapizza.model.Topping
import com.yash.android.bnr.codapizza.model.ToppingPlacement

@Preview
@Composable
private fun ToppingCellPreviewNotOnPizza() {
    ToppingCell(
        topping = Topping.Pepperoni,
        placement = null,
        onClickTopping = {}
    )
}

@Preview
@Composable
private fun ToppingCellPreviewOnLeftHalf() {
    ToppingCell(
        Topping.Basil,
        ToppingPlacement.Left,
        onClickTopping = {}
    )
}

@Composable
public fun ToppingCell(
    topping: Topping,
    placement: ToppingPlacement?,
    onClickTopping: () -> Unit
    ) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = (placement != null), onCheckedChange = { /* TODO */ })
        Column {
            Text(
                text = stringResource(id = topping.toppingName),
                style = MaterialTheme.typography.body1
            )
            if (placement != null) {
                Text(
                    text = stringResource(id = placement.label),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}