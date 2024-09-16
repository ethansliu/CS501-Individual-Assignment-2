package com.example.greetingsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingsapp.ui.theme.GreetingsAppTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }
    // Organize into column
    Column(
        modifier = Modifier.padding(
            top = 220.dp,
            start = 120.dp,
            end = 100.dp
        )
    ) {
        // Input textfield for name
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Your Name") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Button that produces the greeting message
            Button(
                onClick = {greeting = timeOfDay() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.LightGray,
                ),
            ) {
                Text("Press for a greeting!")
            }

        }
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "$greeting$name")

        Spacer(modifier = Modifier.height(150.dp))
    }
}

fun timeOfDay(): String {
    val currTime = Calendar.getInstance()
    val hour = currTime.get(Calendar.HOUR_OF_DAY)

    var timeGreet = ""
    if (hour in 4..10){
        timeGreet = "Good morning "
    }
    else if (hour in 10..13) {
        timeGreet = "Happy lunch "
    }
    else if (hour in 13..17) {
        timeGreet = "Good afternoon "
    }
    else if (hour in 18..22) {
        timeGreet = "Good evening "
    }
    else if (hour in 22..24 || hour in 0..2) {
        timeGreet = "Good night "
    }
    else{
        timeGreet = "Hello "
    }
    return timeGreet
}