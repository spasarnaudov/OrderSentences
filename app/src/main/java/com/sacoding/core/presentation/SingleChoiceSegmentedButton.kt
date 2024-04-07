package com.sacoding.core.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T>SingleChoiceSegmentedButton(
    modifier: Modifier = Modifier,
    items: List<SegmentedButtonItem<T>>,
    selectedItem: SegmentedButtonItem<T>? = null,
    onSelectItem: (SegmentedButtonItem<T>) -> Unit
) {
    var selectedIndex by remember {
        mutableIntStateOf(items.indexOf(selectedItem))
    }
    SingleChoiceSegmentedButtonRow(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
    ) {
        items.forEachIndexed { index, item ->
            SegmentedButton(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onSelectItem.invoke(item)
                },
                shape = SegmentedButtonDefaults.itemShape(
                    index = index,
                    count = items.size
                )
            ) {
                Text(text = item.name)
            }
        }
    }
}