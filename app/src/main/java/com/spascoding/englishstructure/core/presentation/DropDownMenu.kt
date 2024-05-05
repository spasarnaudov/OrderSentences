package com.spascoding.englishstructure.core.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize

@Composable
fun DropDownMenu(
    title: String,
    list: List<String>,
    defaultValue: String = "",
    modifier: Modifier = Modifier,
    iconExpanded: ImageVector = Icons.Filled.KeyboardArrowUp,
    iconNonExpanded: ImageVector = Icons.Filled.KeyboardArrowDown,
    onClick: (String) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var selectedItem by remember {
        mutableStateOf(defaultValue)
    }
    var textFiledSize by remember {
        mutableStateOf(Size.Zero)
    }
    val icon = if (expanded) {
        iconExpanded
    } else {
        iconNonExpanded
    }

    Column() {
        OutlinedTextField(
            value = selectedItem,
            readOnly = true,
            onValueChange = { selectedItem = it },
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .onGloballyPositioned { coordinates ->
                    textFiledSize = coordinates.size.toSize()
                },
            label = { Text(text = title) },
            trailingIcon = {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    Modifier.clickable { expanded = !expanded }
                )
            }
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) {textFiledSize.width.toDp()})
        ) {
            list.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(text = label)
                    },
                    onClick = {
                        selectedItem = label
                        expanded = false
                        onClick.invoke(selectedItem)
                    }
                )
            }
        }
    }
}