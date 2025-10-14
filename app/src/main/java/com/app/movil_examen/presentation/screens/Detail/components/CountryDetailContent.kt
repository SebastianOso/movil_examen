package com.app.movil_examen.presentation.screens.Detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.app.movil_examen.domain.model.Country

@Suppress("ktlint:standard:function-naming")
@Composable
fun CountryDetailContent(country: Country) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //AsyncImage(
        //    model = movie.image,
        //    contentDescription = movie.title,
        //    modifier = Modifier.size(200.dp),
        //)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = country.name,
            style = MaterialTheme.typography.headlineMedium,
        )

        Text(
            text = country.region,
            style = MaterialTheme.typography.headlineSmall,
        )

        Text(
            text = country.currency,
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = country.languages,
            style = MaterialTheme.typography.headlineSmall
        )


        Spacer(modifier = Modifier.height(8.dp))

        Spacer(modifier = Modifier.height(16.dp))
    }
}