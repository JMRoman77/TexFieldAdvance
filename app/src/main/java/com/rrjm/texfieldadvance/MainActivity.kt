package com.rrjm.texfieldadvance

import android.os.Bundle
import android.provider.CalendarContract.Colors
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rrjm.texfieldadvance.ui.theme.TexFieldAdvanceTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TexFieldAdvanceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //MyTexFieldAdvance()
                    MyTextFieldOutLine()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInitial() {
    // MyTexFieldAdvance()

    MyTextFieldOutLine()
}

@Composable
fun MyTexFieldAdvance() {
    var myText by remember { mutableStateOf("") }

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {//Si escribe la letra a será e
                it.replace("a", "e")
            } else if (it.contains(" ")) {//Si escribe un espacio será *
                it.replace(" ", "*")
            } else if (!it.contains("@")) {
                it.replace("@", "Falta la @ capullito")
            } else {
                it.reversed()
            }
        },
        label = { Text(text = "Introduce tu nombre") })

}

@Composable
fun MyTextFieldOutLine() {
    // Declaramos una variable mutable para almacenar el texto ingresado en el primer TextField
    var myText1 by remember { mutableStateOf("") }
    // Declaramos una segunda variable mutable para almacenar el texto ingresado en el segundo TextField
    var myText2 by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText1,
        onValueChange = { myText1 = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Introduce un texto") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue

        )

    )
}
