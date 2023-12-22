package com.example.dekanotes.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.dekanotes.R
import com.example.dekanotes.domain.model.Subject
import com.example.dekanotes.presentation.components.CountCard
import com.example.dekanotes.presentation.components.SubjectCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen() {

    val subjects = listOf(
        Subject(
            name = "Maths",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "Physics",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "Chemistry",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "Biology",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "English",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "Hindi",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "History",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
        Subject(
            name = "Geography",
            goalHour = 10f,
            colors = listOf(Color(0xFF00BFA5), Color(0xFF00BFA5))
        ),
    )



    Scaffold(
        topBar = { DashboardScreenTopBar() }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            item {
                CountCardSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    subjectCount = 5,
                    studiedHours = "10",
                    goalHours = "15"
                )
            }

            item {
                SubjectCardsSection(
                    modifier = Modifier.fillMaxWidth() ,
                    subjectList = subjects
                )
            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreenTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "StudySmart",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )
}

@Composable
fun CountCardSection(
    modifier: Modifier,
    subjectCount: Int,
    studiedHours: String,
    goalHours: String
) {
    Row(modifier = modifier) {
        CountCard(modifier = Modifier.weight(1f), headingText = "subject Count", count = "$subjectCount")
        Spacer(modifier = Modifier.width(10.dp))

        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Studied Hours",
            count = studiedHours
        )
        Spacer(modifier = Modifier.width(10.dp))

        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Goal Study Hours",
            count = goalHours
        )
        Spacer(modifier = Modifier.width(10.dp))
    }
}



@Composable
fun SubjectCardsSection(
    modifier: Modifier,
    subjectList: List<Subject>,
    emptyListText : String = "you have no subjects yet. \n click + to add one"
) {

    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Subjects",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp)
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add subject")
            }

        }

        if (subjectList.isEmpty()) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(id = R.drawable.book),
                contentDescription = emptyListText,
            )
            
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = emptyListText,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ){
            items(subjectList){ subject ->
                SubjectCard(
                    subjectName = subject.name,
                    gradientColors = subject.colors,
                    onClick = {}
                )
        }
    }
}
}