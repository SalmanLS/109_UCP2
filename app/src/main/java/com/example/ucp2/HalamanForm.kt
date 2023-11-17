@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun HalamanForm(
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onSelectionChanged1: (String) -> Unit,
    onSelectionChanged2: (String) -> Unit,
    dospemb1: List<String>,
    dospemb2: List<String>,
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var nim by rememberSaveable { mutableStateOf("") }
    var konsen by rememberSaveable { mutableStateOf("") }
    var judul by remember { mutableStateOf("") }

    var dospemDipilih1 by remember { mutableStateOf("") }
    var dospemDipilih2 by remember { mutableStateOf("") }

    var listData: MutableList<String> = mutableListOf(nama, nim, konsen, judul, dospemDipilih1, dospemDipilih2)


    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
        ) {
        Text(text = "Formulir Pengajaun Skripsi")

        OutlinedTextField(value = nama, onValueChange = { nama = it }, label = {
            Text(
                text = "Nama Mahasiswa"
            ) }
        )

        OutlinedTextField(value = nim, onValueChange = { nim = it }, label = {
            Text(
                text = "NIM"
            ) }
        )
        OutlinedTextField(value = konsen, onValueChange = { konsen = it }, label = {
            Text(
                text = "Konsentrasi"
            ) }
        )
        OutlinedTextField(value = judul, onValueChange = { judul = it }, label = {
            Text(
                text = "Judul Skripsi"
            ) }
        )

        Row (
            modifier= Modifier,
        ){
            Column {
                Text(text = "Dosen Pembimbing 1")
                dospemb1.forEach { item ->
                    Row (
                        modifier = Modifier.selectable(
                            selected = dospemDipilih1 == item,
                            onClick = {
                                dospemDipilih1 = item
                                onSelectionChanged1(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = dospemDipilih1 == item,
                            onClick = {
                                dospemDipilih1 = item
                                onSelectionChanged1(item)
                            }
                        )
                        Text(item)
                    }
                }
            }
            Column {
                Text(text = "Dosen Pembimbing 2")
                dospemb2.forEach { item ->
                    Row (
                        modifier = Modifier.selectable(
                            selected = dospemDipilih2 == item,
                            onClick = {
                                dospemDipilih2 = item
                                onSelectionChanged2(item)
                            }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        RadioButton(
                            selected = dospemDipilih2 == item,
                            onClick = {
                                dospemDipilih2 = item
                                onSelectionChanged2(item)
                            }
                        )
                        Text(item)
                    }
                }
            }
        }
        Button(
            // the button is enabled when the user makes a selection
            onClick = { onSubmitButtonClicked(listData) }
        ) {
            Text(text = "Submit")
        }

    }
}