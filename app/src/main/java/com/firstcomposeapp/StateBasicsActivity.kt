package com.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme
import kotlin.random.Random

class StateBasicsActivity : ComponentActivity() {

    //For state remember 2 things : remember function and mutableState
    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()

                }
            }
        }
    }


    @Composable
    fun CaptainGame() {
        //remember is used to remember the current state, and maintain it during recomposition i.e screen refresh
        //While using mutableSetof we can change the state and whenver new change or state is update.
        //screen is redrawn.

        // we are using val because we are assigning new value of remember { mutableStateOf()} to this
        // treasuresFound.value is internal value which we are able to change. Its like treasuresFound
        //is a treasure box containing coins. so we are changing coins in the treasure box i.e by taking
        //few coins. We are not changing the treasure box itself with another.

        val treasuresFound = remember { mutableStateOf(0) }
        //by keyword: By using this by keyword, while changing directions value, we don't need to
        //write directions.value, instead we write directions only, because now the directions directly
        //represents the value itself instead of a mutablestate through which we fetch value.
        var directions by remember { mutableStateOf("North") }


        Column {

            Text(text = "Treasure found : ${treasuresFound.value}")
            //Notice we are not using directions value here.
            Text(text = "Current Direction : $directions")

            Button(onClick = {
                directions = "East"
                //if random hit true, we add one to treasures.
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail East")
            }

            Button(onClick = {
                directions = "North"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail North")
            }
            Button(onClick = {
                directions = "West"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail West")
            }
            Button(onClick = {
                directions = "South"
                if (Random.nextBoolean()) {
                    treasuresFound.value += 1
                }
            }) {
                Text(text = "Sail South")
            }
        }

        //Conclusion, if we have some variables or any other type, and we want to update screen
        //when their value changes, and also use them directly inside any composable then use this
        //remember{mutableStateOf()}  mutableStateOf means any value inside it can changed, and when
        //it get changed, then application need to remember that it is changed and it needs to
        //update user interface.
    }
}
