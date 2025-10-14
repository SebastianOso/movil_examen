package com.app.movil_examen.presentation.screens.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.app.movil_examen.presentation.screens.Home.components.CountryListContent


@Suppress("ktlint:standard:function-naming")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onCountryClick: (String) -> Unit,
    onReqsClick: () -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    var selectedTabIndex by remember { mutableStateOf(0) }
    var searchQuery by remember { mutableStateOf("") }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    // Filtrar personajes según la búsqueda
    val filteredCountries =
        uiState.countryList.filter { country ->
            country.name.contains(searchQuery, ignoreCase = true)
        }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Countries") },
            )
        },
    ) { padding ->
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(padding),
        ) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text("Seach country...") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = "Search")
                },
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                singleLine = true,
            )

            Button(
                onClick = onReqsClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Go to Reqs screen")
            }

            // Character List
            when (selectedTabIndex) {
                0 ->
                    CountryListContent(
                        countryList = filteredCountries,
                        isLoading = uiState.isLoading,
                        error = uiState.error,
                        onCountryClick = onCountryClick,
                    )
            }
        }
    }
}