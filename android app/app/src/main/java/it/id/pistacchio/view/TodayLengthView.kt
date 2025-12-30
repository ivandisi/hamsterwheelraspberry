package it.id.pistacchio.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import it.id.pistacchio.view.generic.DailyLengthRowChart
import it.id.pistacchio.view.generic.Header

@Composable
fun DailyLengthView() {
    Column {
        Header()

        Text(
            text = "Today I'm running for ...",
            modifier = Modifier
                .padding(8.dp)
        )
        DailyLengthRowChart(
            modifier = Modifier
                .padding(16.dp, 0.dp)

        )
    }
}