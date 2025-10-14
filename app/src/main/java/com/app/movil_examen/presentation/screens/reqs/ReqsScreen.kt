package com.app.movil_examen.presentation.screens.reqs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Suppress("ktlint:standard:function-naming")
@Composable
fun ReqsScreen(onBackClick: (() -> Unit)? = null) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Requisitos") },
                navigationIcon = {
                    onBackClick?.let {
                        IconButton(onClick = it) {
                            Icon(Icons.Default.ArrowBack, "Back")
                        }
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Arquitectura",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "En la aplicacion se implementa la arquitectura de MVVM + Clean, se puede ver como es que esta la capa de presentacion con sus respectivos viewmodel y views, como tambien tenemos la capa de datos y dominio, que estas se van a comunicar entre si mediante repositorios e interfaces. para pasarle toda la informacion recabada del remoto (API) a nuestra vista",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Estrategia de guardado de preferencias",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "Para este caso, se hizo uso de una carpeta en la sección de data, para tenelo en 'local', y se hizo uso de las shared preferences, pero solo sirve para el caso de la lista general de los paises, tuve unso problemas a la hora de usar el cache en la pantalla de details",
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = "Estrategia de búsqueda",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "La búsqueda en HomeScreen funciona con una barra de texto donde escribes el pais que quieres buscar, y ya con eso se guarda en el searchQuery, para más adelante ese texto filtra la lista de países que funciona con el uiState.countryList del ViewModel de la homescreen, buscando en el campo name sin importar si usas mayúsculas o minúsculas y la lista filtrada o resultante se actualiza en la homescreen ",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}