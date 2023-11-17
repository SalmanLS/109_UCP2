package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ucp2.data.FormUiState

@Composable
fun HalamanView(
    formUiState: FormUiState,
    onBackButtonClicked: () -> Unit
){
    val items = listOf(
        Pair(stringResource(id = R.string.nama), formUiState.nama),
        Pair(stringResource(id = R.string.nim), formUiState.nim),
        Pair(stringResource(id = R.string.konsen), formUiState.konsen),
        Pair(stringResource(id = R.string.judul), formUiState.judul),
        Pair(stringResource(id = R.string.dsp1), formUiState.dosen1),
        Pair(stringResource(id = R.string.dsp2), formUiState.dosen2),
        )
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                Column {
                    Text(item.first, fontWeight = FontWeight.Bold)
                    Text(text = item.second, fontWeight = FontWeight.Bold)
                }
                Divider(
                    thickness = 1.dp
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                // the button is enabled when the user makes a selection
                onClick =  onBackButtonClicked
            ) {
                Text(text = "Back")
            }
        }

    }
}