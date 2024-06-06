package com.fiap.guilhermesouzadacruz_rm95088

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fiap.guilhermesouzadacruz_rm95088.ui.theme.GuilhermeSouzadaCruz_RM95088Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuilhermeSouzadaCruz_RM95088Theme {
                PraiaScreen()
            }
        }
    }

    @Composable
    fun PraiaScreen(viewModel: ItemsViewModel = viewModel()) {
        var nomePraia by remember { mutableStateOf(TextFieldValue("")) }
        var cidade by remember { mutableStateOf(TextFieldValue("")) }
        var estado by remember { mutableStateOf(TextFieldValue("")) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TextField(
                value = nomePraia,
                onValueChange = { nomePraia = it },
                label = { Text("Nome da praia") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = cidade,
                onValueChange = { cidade = it },
                label = { Text("Cidade") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = estado,
                onValueChange = { estado = it },
                label = { Text("Estado") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val novaPraia = ItemModel(nomePraia.text, cidade.text, estado.text)
                    viewModel.addItem(novaPraia)
                    nomePraia = TextFieldValue("")
                    cidade = TextFieldValue("")
                    estado = TextFieldValue("")
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Incluir")
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(viewModel.items) { praia ->
                    Text("${praia.name}, ${praia.city}, ${praia.state}", style = MaterialTheme.typography.bodyLarge)
                    Divider()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        GuilhermeSouzadaCruz_RM95088Theme {
            PraiaScreen()
        }
    }
}