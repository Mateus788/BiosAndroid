package com.example.biosandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerUI()
        }
    }
}

@Composable
fun TaskManagerUI() {
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var status by remember { mutableStateOf(false) }
    var priority by remember { mutableStateOf("Low") }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Title", color = Color.White)
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.White)
        )

        Text(text = "Status", color = Color.White)
        Row {
            RadioButton(selected = status, onClick = { status = true })
            Text(text = "Done", color = Color.White)
            Spacer(modifier = Modifier.width(16.dp))
            RadioButton(selected = !status, onClick = { status = false })
            Text(text = "Not Done", color = Color.White)
        }

        Text(text = "Priority:", color = Color.White)
        Row {
            listOf("Low", "Medium", "High").forEach { level ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = priority == level,
                        onClick = { priority = level }
                    )
                    Text(text = level, color = Color.White)
                    Spacer(modifier = Modifier.width(16.dp))
                }
            }
        }

        Text(text = "Time and Date", color = Color.White)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
            Button(
                onClick = { /* Choose date logic */ },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Choose Date")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* Choose time logic */ },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Choose Time")
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = { /* Cancel logic */ },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Cancel")
            }
            Button(
                onClick = { /* Reset logic */ },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Reset")
            }
            Button(
                onClick = { /* Submit logic */ },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Submit")
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewTaskManagerUI() {
    TaskManagerUI()
}
