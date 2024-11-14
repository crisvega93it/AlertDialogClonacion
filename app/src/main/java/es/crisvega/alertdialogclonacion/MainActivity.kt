package es.crisvega.alertdialogclonacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat.Style
import es.crisvega.alertdialogclonacion.ui.theme.AlertDialogClonacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialogClonacionTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var show by rememberSaveable { mutableStateOf(false) }
    var TextoConf by rememberSaveable { mutableStateOf(false) }
    var showDel by rememberSaveable { mutableStateOf(false) }
    var TextoDel by rememberSaveable { mutableStateOf(false) }
    var showImp by rememberSaveable { mutableStateOf(false) }
    var showAuten by rememberSaveable { mutableStateOf(false) }
    var TextoAuten by rememberSaveable { mutableStateOf(false) }
    var showButton by rememberSaveable { mutableStateOf(true) }
    var showError by rememberSaveable { mutableStateOf(false) }
    var TextoError by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showButton) {
            Button(onClick = {
                show = true
                showButton = false
                TextoConf = false
                TextoDel = false
                TextoError = false
            }) {
                Text("Mostrar")
            }

            Spacer(Modifier.padding(15.dp))

            Button(onClick = {
                show = false
                showDel = true
                TextoConf = false
                TextoDel = false
                TextoError = false
                TextoAuten = false
                TextoConf = false
            }) {
                Text("Eliminar")
            }

            Spacer(Modifier.padding(15.dp))

            Button(onClick = {
                show = false
                showButton = false
                showImp = true
                TextoConf = false
                TextoDel = false
                TextoError = false
                TextoAuten = false
            }) {
                Text("Entendido")
            }

            Spacer(Modifier.padding(15.dp))

            Button(onClick = {
                show = false
                showButton = false
                showAuten = true
                TextoConf = false
                TextoDel = false
                TextoError = false
                TextoAuten = false
            }) {
                Text("Autentificar")
            }

            Spacer(Modifier.padding(15.dp))

            Button(onClick = {
                show = false
                showButton = false
                showError = true
                TextoConf = false
                TextoDel = false
                TextoAuten = false
                TextoError = false
            }) {
                Text("Error Crítico")
            }
        }
        MyAlertDialogConf(show,
            disMiss = {
                show = false
                showButton = true
            },
            cambiarTexto = {
                TextoConf = true
            }
        )

        MyAlertElim(showDel,
            disMiss = {
                showDel = false
                showButton = true
            },
            cambiarTexto = {
                TextoDel = true
            }
        )

        MyAlertImp(showImp,
            disMiss = {
                showImp = false
                showButton = true
            }
        )

        MyAlertDialogAutentificar(showAuten,
            disMiss = {
                showAuten = false
                showButton = true
            },
            cambiarTexto = {
                TextoAuten = true
            }
        )

        MyAlertError(showError,
            disMiss = {
                showError = false
                showButton = true
            },
            cambiarTexto = {
                TextoError = true
            }
        )

        if(TextoConf){
            Text("Acción Confirmada")
        }
        if(TextoDel){
            Text("Eliminado Correctamente"
            , color = Color.Red)
        }
        if(TextoAuten){
            Text("Usuario Autenticado"
                , color = Color.Green)
        }
        if(TextoError){
            Text("Intento de Reintento"
                , color = Color.Green)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AlertDialogClonacionTheme {
        Greeting("Android")
    }
}