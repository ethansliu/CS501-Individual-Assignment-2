package com.example.quoteofthedayapp

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteofthedayapp.ui.theme.QuoteOfTheDayAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuoteOfTheDayAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomQuote()
                }
            }
        }
    }
}

@Composable
fun RandomQuote() {
    var randomMotivationalQuote by remember { mutableStateOf("") }
    // List for the quotes
    val motivationalQuotes = listOf(
        "The only way to do great work is to love what you do. – Steve Jobs",
        "Success usually comes to those who are too busy to be looking for it. – Henry David Thoreau",
        "Don’t be afraid to give up the good to go for the great. – John D. Rockefeller",
        "I find that the harder I work, the more luck I seem to have. – Thomas Jefferson",
        "Success is not in what you have, but who you are. – Bo Bennett",
        "Opportunities don't happen. You create them. – Chris Grosser",
        "The secret of getting ahead is getting started. – Mark Twain",
        "What you get by achieving your goals is not as important as what you become by achieving your goals. – Zig Ziglar",
        "Your time is limited, so don’t waste it living someone else’s life. – Steve Jobs",
        "It is never too late to be what you might have been. – George Eliot",
        "The only limit to our realization of tomorrow is our doubts of today. – Franklin D. Roosevelt",
        "The future belongs to those who believe in the beauty of their dreams. – Eleanor Roosevelt",
        "Hardships often prepare ordinary people for an extraordinary destiny. – C.S. Lewis",
        "You miss 100% of the shots you don’t take. – Wayne Gretzky",
        "Act as if what you do makes a difference. It does. – William James",
        "The best way to predict the future is to invent it. – Alan Kay",
        "The only place where success comes before work is in the dictionary. – Vidal Sassoon",
        "Whether you think you can or you think you can’t, you’re right. – Henry Ford",
        "Do not wait to strike till the iron is hot; but make it hot by striking. – William Butler Yeats",
        "The harder the conflict, the greater the triumph. – George Washington"
    )

    // Organizes the quote and button into a column
    Column(
        modifier = Modifier.padding(
            top = 350.dp,
            start = 100.dp,
            end = 100.dp
        )
    ) {
        //Puts the quote above the button
        Text(text = randomMotivationalQuote, color = Color.Blue, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(150.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Button that changes the quote on click by passing a
            // random quote to randomMotivationalQuote
            Button(
                onClick = {randomMotivationalQuote = motivationalQuotes[Random.nextInt(motivationalQuotes.size)] },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.DarkGray,
                    contentColor = Color.LightGray,
                ),
                ) {
                Text("Press to Change Quote!")
            }
        }
    }
}


