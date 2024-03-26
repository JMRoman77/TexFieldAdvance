package com.rrjm.texfieldadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
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
                    MyTexFieldAdvance()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInitial() {
    MyTexFieldAdvance()
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
            } else if (!it.contains("@")){
it.replace("@","Falta la @ capullito")
            }else{
                it.reversed()
            }
        },
        label = { Text(text = "Introduce tu nombre") })

}


