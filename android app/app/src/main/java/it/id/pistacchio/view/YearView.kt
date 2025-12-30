package it.id.pistacchio.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import it.id.pistacchio.view.generic.Header
import it.id.pistacchio.view.generic.YearRowChart

@Composable
fun YearView() {
    Column {
        Header()

        Text(
            text = "This year I'm doing ...",
            modifier = Modifier
                .padding(8.dp)
        )
        YearRowChart(
            modifier = Modifier
                .padding(8.dp)

        )
    }
}