package com.yash.android.bnr.codapizza.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.yash.android.bnr.codapizza.R
import com.yash.android.bnr.codapizza.model.PizzaSize

@Composable
fun PizzaSizeDropdownMenu(
    expanded: Boolean,
    modifier: Modifier = Modifier,
    onSetPizzaSize: (size: PizzaSize) -> Unit,
    onDropdownButtonClicked: () -> Unit,
    onDismissRequest: () -> Unit
) {
    Column {
        Button(
            onClick = onDropdownButtonClicked,
            modifier = modifier.padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.size_button_text))
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            modifier = modifier,
        ) {
            PizzaSize.entries.forEach { pizzaSize ->
                PizzaSizeDropdownMenuItem(
                    sizeName = pizzaSize.size,
                    onClick = {
                        onSetPizzaSize(pizzaSize)
                        onDismissRequest()
                    }
                )
            }
        }
    }
}

@Composable
fun PizzaSizeDropdownMenuItem(
    @StringRes sizeName: Int,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = sizeName),
            modifier = Modifier.padding(8.dp)
        )
    }
}

