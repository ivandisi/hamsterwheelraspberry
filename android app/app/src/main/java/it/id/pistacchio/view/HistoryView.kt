package it.id.pistacchio.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.boguszpawlowski.composecalendar.StaticCalendar
import io.github.boguszpawlowski.composecalendar.rememberCalendarState
import it.id.pistacchio.view.generic.Header
import it.id.pistacchio.view.generic.RecapView
import it.id.pistacchio.viewmodel.DailySearchViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun HistoryView(viewModel: DailySearchViewModel = viewModel()) {
    val cs = rememberCalendarState()
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    selectedDate = LocalDate.now()
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy MM dd")
    var label = today.format(formatter)

    Column {
        Header()

        StaticCalendar(
            calendarState =  cs,
            dayContent = { dayState ->
                Box(
                    modifier = Modifier
                        .clickable {
                            selectedDate = dayState.date
                            label = "" + selectedDate?.year + " " + selectedDate?.month?.value?.let {
                                String.format("%02d", it)
                            } + " " + selectedDate?.dayOfMonth?.let {
                                String.format("%02d", it)
                            }
                            viewModel.fetchDataFromApi(
                                "" + selectedDate?.year
                                        + selectedDate?.month?.value?.let {
                                    String.format("%02d", it)
                                } + selectedDate?.dayOfMonth?.let {
                                    String.format("%02d", it)
                                })
                        }
                        .background(
                            if (dayState.date == selectedDate)
                                Color.Gray
                            else Color.Transparent
                        )
                        .padding(8.dp)
                ) {
                    Text(dayState.date.dayOfMonth.toString())
                }
            })
        Text(
            "Searching for: $label",
            modifier = Modifier
                .padding(10.dp))
        RecapView(viewModel)
    }
}