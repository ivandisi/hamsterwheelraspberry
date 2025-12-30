package it.id.pistacchio.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import it.id.pistacchio.R
import it.id.pistacchio.view.generic.Header
import it.id.pistacchio.view.generic.RecapView
import it.id.pistacchio.viewmodel.DailyLengthViewModel
import it.id.pistacchio.viewmodel.DailyViewModel
import it.id.pistacchio.viewmodel.YearViewModel


@Composable
fun HomeView( viewModel: DailyViewModel = viewModel(), lengthViewModel: DailyLengthViewModel = viewModel(), yearViewModel: YearViewModel = viewModel() ) {
    Column {
        Header()

        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            modifier = Modifier
                .size(420.dp,205.dp)
                .padding(8.dp, 8.dp)
        ) {
            Row {
                IconButton(
                    onClick = {
                        viewModel.fetchDataFromApi()
                        lengthViewModel.fetchDataFromApi()
                        yearViewModel.fetchDataFromApi()
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.refresh),
                        contentDescription = stringResource(id = R.string.refresh),
                        modifier = Modifier
                            .padding(8.dp)
                            .size(28.dp)
                    )
                }
                Text(
                    text = "Hello I'm Pistacchio !",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(12.dp)
                )
            }
        }
        RecapView(viewModel)
    }
}


