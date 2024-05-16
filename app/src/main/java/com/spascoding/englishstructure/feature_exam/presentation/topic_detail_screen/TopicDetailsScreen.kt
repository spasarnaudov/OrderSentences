package com.spascoding.englishstructure.feature_exam.presentation.topic_detail_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.spascoding.englishstructure.core.constants.Padding
import com.spascoding.englishstructure.core.constants.RoundCorner
import com.spascoding.englishstructure.feature_exam.presentation.utils.upperFirstLetter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamDetails(
    viewModel: TopicDetailViewModel = hiltViewModel()
) {
    val sentences by viewModel.getSentences().collectAsState(initial = emptyList())
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent,
                    titleContentColor = MaterialTheme.colorScheme.onBackground,
                ),
                title = { Text("${viewModel.state.value.topic.upperFirstLetter()} (${viewModel.state.value.tense.value.upperFirstLetter()})") },
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
            itemsIndexed(sentences) { i, sentence ->
                Box(
                    modifier = Modifier.padding(
                        start = Padding.MEDIUM,
                        bottom = Padding.MEDIUM,
                        end = Padding.MEDIUM,
                    )
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                MaterialTheme.colorScheme.background, RoundedCornerShape(
                                    RoundCorner.MEDIUM
                                )
                            )
                            .border(
                                1.dp,
                                MaterialTheme.colorScheme.onBackground,
                                RoundedCornerShape(RoundCorner.MEDIUM)
                            )
                            .padding(Padding.MEDIUM),
                        text = """${i + 1}. ${sentence.value}
                                |Mistake count: ${sentence.mistakeCount}
                                |Used count: ${sentence.usedCount}
                            """.trimMargin(),
                    )
                }
            }
        }
    }
}