@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.data.SumberData.dospem


enum class PengelolaHalaman {
    Home,
    Form,
    View
}

@Composable
fun Ucp2App(
    viewModel: FormViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanHome(
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Form.name)
                    }
                )
            }
            composable(route = PengelolaHalaman.Form.name) {
                val context = LocalContext.current
                HalamanForm(
                    dospemb1 = dospem.map { id -> context.resources.getString(id) },
                    dospemb2 = dospem.map { id -> context.resources.getString(id) },
                    onSelectionChanged1 = { viewModel.setD1(it) },
                    onSelectionChanged2 = { viewModel.setD2(it) },
                    onSubmitButtonClicked = {
                        viewModel.setForm(it)
                        navController.navigate(PengelolaHalaman.View.name)
                    },

                )
            }
            composable(route = PengelolaHalaman.View.name) {
                HalamanView(
                    formUiState = uiState,
                    onBackButtonClicked = { cancelOrderAndNavigateToRasa(navController) }
                )
            }

        }

    }

}

private fun cancelOrderAndNavigateToRasa(
    navController: NavHostController
) {
    navController.popBackStack(PengelolaHalaman.Form.name, inclusive = false)
}
