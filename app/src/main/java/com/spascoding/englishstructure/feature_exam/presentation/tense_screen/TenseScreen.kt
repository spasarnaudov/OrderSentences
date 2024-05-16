package com.spascoding.englishstructure.feature_exam.presentation.tense_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.spascoding.englishstructure.R
import com.spascoding.englishstructure.core.presentation.MinimalDialog
import com.spascoding.englishstructure.feature_exam.domain.enums.Tense
import com.spascoding.englishstructure.feature_exam.domain.model.getTenseInfo
import com.spascoding.englishstructure.feature_exam.presentation.Screen
import com.spascoding.englishstructure.feature_exam.presentation.components.ListElement
import com.spascoding.englishstructure.feature_exam.presentation.utils.getAppVersion
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TenseScreen(
    navController: NavController,
    viewModel: TenseScreenViewModel = hiltViewModel(),
) {
    val tenseInfoList by viewModel.getTenseInfoFlow().collectAsState(initial = emptyList())

    val appVersion = stringResource(R.string.app_version, getAppVersion(LocalContext.current))
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    val dialogMassage = remember { mutableStateOf("") }
    if (dialogMassage.value.isNotBlank()) {
        MinimalDialog(
            dialogMassage.value
        ) {
            dialogMassage.value = ""
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = {
                    Text(
                        stringResource(R.string.tenses),
                    )
                },
                actions = {
                    IconButton(onClick = { dialogMassage.value = appVersion }) {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = stringResource(R.string.app_description)
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            columns = StaggeredGridCells.Fixed(1),
        ) {
            items(Tense.entries) { tense ->
                ListElement(
                    cellText = tense.value.upperFirstLetter(),
                    progressPercentage = tenseInfoList.getTenseInfo(tense).accuracy.toFloat() / 100f,
                    progressColor = tense.color,
                    onClickInfo = {
                        dialogMassage.value = tense.value.upperFirstLetter()
                    },
                ) {
                    navController.navigate(Screen.TopicsScreen.route + "?tense=${tense.int}")
                }
            }
        }
    }
}