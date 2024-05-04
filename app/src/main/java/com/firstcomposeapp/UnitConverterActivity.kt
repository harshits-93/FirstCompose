package com.firstcomposeapp

import android.icu.util.Output
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme

class UnitConverterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    UnitConverter()
                }
            }
        }
    }

    @Composable
    private fun UnitConverter() {

        var inputValue by remember { mutableStateOf("") }
        var outputValue by remember { mutableStateOf("") }
        var inputUnit by remember { mutableStateOf("Centimeters") }
        var outputUnit by remember { mutableStateOf("meters") }
        var iExpanded by remember { mutableStateOf(false) }
        var oExpanded by remember { mutableStateOf(false) }
        var conversionRate by remember { mutableDoubleStateOf(0.01) }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            //this fillmaxsize here means max size where all content inside column is covered, not the
            //entire screen size.
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Unit Converter")
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = inputValue,
                onValueChange = {
                    inputValue = it
                },
                label = { Text(text = "Enter value") })

            Spacer(modifier = Modifier.height(16.dp))

            Row {
                Box {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Select")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                    }

                    DropdownMenu(expanded = false, onDismissRequest =
                    { /*TODO*/ }) {

                        DropdownMenuItem(text = { "Centimeters" }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { "Meters" }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { "feet" }, onClick = { /*TODO*/ })

                    }


                }

                Spacer(modifier = Modifier.width(16.dp))

                Box {
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Select")
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                    }

                    DropdownMenu(expanded = false, onDismissRequest =
                    { /*TODO*/ }) {

                        DropdownMenuItem(text = { "Centimeters" }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { "Meters" }, onClick = { /*TODO*/ })
                        DropdownMenuItem(text = { "feet" }, onClick = { /*TODO*/ })

                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Result : ")

        }
    }
}
