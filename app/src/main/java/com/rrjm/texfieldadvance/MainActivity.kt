package com.rrjm.texfieldadvance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rrjm.texfieldadvance.ui.theme.TexFieldAdvanceTheme

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
                    //MyTextFieldOutLine()
                    MyCard()
                    MyButtonExample()

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInitial() {
    //MyTexFieldAdvance()
    MyCard()

    MyButtonExample()
    //MyImage()
    //Spacer(modifier = Modifier.height(20.dp))
    //MyTextFieldOutLine()

}

@Composable
fun MyCard() {
    var myText by remember { mutableStateOf("") }
    Card(
        modifier = Modifier
            .fillMaxWidth() //Usa todo el ancho de la pantalla
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black, // Cambia este color al que desees
            contentColor = Color.White, // Cambia este color si deseas personalizar el color del texto dentro de la tarjeta
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),

        ) {
        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = myText,
                onValueChange = {
                    myText = if (it.contains("a")) {//Si escribe la letra a será A
                        it.replace("a", "A")
                    } else if (it.contains(" ")) {//Si escribe un espacio será *
                        it.replace(" ", "*")
                    } else if (!it.contains("@")) {
                        it.replace("@", "Falta la @ capullito")
                    } else {
                        it.lowercase() //pone el texto en minuscula
                    }
                },
                label = { Text("Introduce tu nombre") })

        }
    }

}



//EJemplos de botones
@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(36.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyImage()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp), // Añade un espacio vertical entre la fila y el borde de la pantalla
            horizontalArrangement = Arrangement.Center // Centra el botón horizontalmente en la fila
        ) {

            Button(
                onClick = { enabled = false },
                enabled = enabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Magenta,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Start")
            }
        }

        //Otro tipo de boton, básicamente es el borde del botón
        //con lo que quieras ponerle dentro.
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "COMENZAR")
            
        }
        //Un boton de texto o de otra cosa sin borde
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Terminar")
            
        }
    }
}

//Componente Imagen llamando a drawable
@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.cerveza),
        contentDescription = "Vaso de Cruzcampo",
        //alpha = 0.7f,//Hace la imagen mas transparente
        modifier = Modifier
            .fillMaxWidth()
            .padding(96.dp))
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
        label = { Text("Introduce tu nombre") }
    )

}

@Composable
fun MyTextFieldOutLine() {
    // Declaramos una variable mutable para almacenar el texto ingresado en el primer TextField
    var myText1 by remember { mutableStateOf("") }

    OutlinedTextField(
        value = myText1,
        onValueChange = { myText1 = it },
        modifier = Modifier.padding(24.dp),
        label = { Text(AnnotatedString("Introduce un texto")) },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Magenta,//Cambia el color del borde
            unfocusedBorderColor = Color.Blue//Cambia el color del borde

        )

    )
}