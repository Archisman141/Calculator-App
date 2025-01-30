package com.example.calculatorapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var number1 by remember {
                mutableStateOf("0") //this will remember that the value of the number1 initially was 0
            }
            var number2 by remember {
                mutableStateOf("0") //this will remember that the value of the number1 initially was 0
            }
            Column {
                //Now this zero value can never be changed because it is a constant
                //To change it we need to use a variable
                TextField(value = number1, onValueChange = {
                    number1 = it //Now this will change the value of the number1 whenever new value is assigned
                })
                TextField(value = number2, onValueChange = {
                    number2 = it //Now this will change the value of the number2 whenever new value is assigned
                })
                Row (){
                    Button(onClick = {
                        var result = number1.toInt() + number2.toInt()
                        Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Add")
                    }
                    Button(onClick = {
                        var result = number1.toInt() - number2.toInt()
                        Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Sub")
                    }
                    Button(onClick = {
                        var result = number1.toInt() * number2.toInt()
                        Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Multi")
                    }
                    Button(onClick = {
                        var result = number1.toInt() / number2.toInt()
                        Toast.makeText(applicationContext, result.toString(), Toast.LENGTH_SHORT).show()
                    }) {
                        Text("Div")
                    }
                }

            }

        }
    }
}
