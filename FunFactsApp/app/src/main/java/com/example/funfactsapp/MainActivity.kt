package com.example.funfactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.example.funfactsapp.ui.theme.FunFactsAppTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RandomQuote()
                }
            }
        }
    }
}

@Composable
fun RandomQuote() {

    var randomFactsAndTrivia by remember { mutableStateOf("") }
    // List for the facts and trivia
    val factsAndTrivia = listOf(
        "Honey never spoils; archaeologists have found pots of honey in ancient Egyptian tombs that are over 3,000 years old and still edible.",
        "Bananas are berries, but strawberries aren't.",
        "Wombat poop is cube-shaped.",
        "A group of flamingos is called a 'flamboyance.'",
        "Octopuses have three hearts.",
        "The Eiffel Tower can be 15 cm taller during the summer due to the expansion of iron in the heat.",
        "The shortest war in history was between Britain and Zanzibar on August 27, 1896. Zanzibar surrendered after 38 minutes.",
        "The inventor of the Pringles can is now buried in one.",
        "There are more stars in the universe than grains of sand on all the Earth's beaches.",
        "Hot water freezes faster than cold water, a phenomenon known as the Mpemba effect.",
        "A day on Venus is longer than a year on Venus.",
        "Some sea cucumbers fight by shooting their internal organs out of their bodies.",
        "Humans share 60% of their DNA with bananas.",
        "Kangaroos can't walk backward.",
        "The Guinness World Record for the longest hiccuping spree is held by Charles Osborne, who hiccuped for 68 years.",
        "The dot over the letter 'i' is called a tittle.",
        "There's an island in Japan you can visit that's inhabited only by friendly bunnies, known as Okunoshima.",
        "The human nose can detect about 1 trillion different scents.",
        "A cloud can weigh more than a million pounds.",
        "Your heart beats about 100,000 times a day."
    )

    // Organizes the facts and trivia and button into a column
    Box(
        modifier = Modifier
            .background(color = Color(0xFF8D6DB0))
    ) {
        Column(
            modifier = Modifier
                .padding(
                    top = 150.dp,
                    start = 62.dp
                )
        ){
            Text(
                text = "Fun Facts and Trivia!",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 350.dp)

        ) {
            //Puts the fact/trivia above the button
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp)
                    .border(2.dp, color = Color(0xFFb2a1c7))
                    .background(color = Color(0xFFc7b4de))

            ) {
                Text(
                    text = randomFactsAndTrivia,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = Color.DarkGray
                )
            }

            Spacer(modifier = Modifier.height(100.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                // Button that changes the quote on click by passing a
                // random fact/trivia to randomFactsAndTrivia

                Button(
                    onClick = {
                        randomFactsAndTrivia = factsAndTrivia[Random.nextInt(factsAndTrivia.size)]
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF684896),
                        contentColor = Color.LightGray
                    ),
                    modifier = Modifier
                        .padding(start = 150.dp)

                ) {
                    Text("Next fact")
                }


            }
            Spacer(modifier = Modifier.height(600.dp))
        }
    }
}
