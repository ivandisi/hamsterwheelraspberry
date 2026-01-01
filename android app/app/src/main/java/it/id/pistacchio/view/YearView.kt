package it.id.pistacchio.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import it.id.pistacchio.view.generic.Header
import it.id.pistacchio.view.generic.YearRowChart
import it.id.pistacchio.viewmodel.YearViewModel
import java.util.Locale

@Composable
fun YearView(yearViewModel: YearViewModel = viewModel() ) {
    Column {
        Header()

        Text(
            text = "This year I'm doing a total of ${yearViewModel.totalLength.value.let {  String.format(Locale.getDefault(), "%.2f", it) }}km ...",
            modifier = Modifier
                .padding(8.dp)
        )

        YearRowChart(
            modifier = Modifier
                .padding(8.dp)

        )
    }
}