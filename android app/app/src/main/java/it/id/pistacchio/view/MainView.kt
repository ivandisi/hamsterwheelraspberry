package it.id.pistacchio.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

    Box(modifier = Modifier.fillMaxSize()) {

        Column {
            Header()

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                ),
                modifier = Modifier
                    .size(420.dp, 305.dp)
                    .padding(8.dp, 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
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
                            text = "Hello I'm Pistacchio!",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(12.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image),
                            contentDescription = null,
                            Modifier.height(400.dp)
                                .width(400.dp)
                        )
                    }
                }
            }
            RecapView(viewModel)
        }

        if (viewModel.isLoading.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.3f)),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}


