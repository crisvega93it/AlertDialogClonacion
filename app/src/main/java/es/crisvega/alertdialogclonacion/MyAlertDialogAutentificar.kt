package es.crisvega.alertdialogclonacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAlertDialogAutentificar(
    show: Boolean,
    disMiss: () -> Unit,
    cambiarTexto: () -> Unit
) {

    if (show) {
        BasicAlertDialog(
            onDismissRequest = { disMiss() }
        ) {
            Surface(
                Modifier
                    .wrapContentWidth().wrapContentHeight(),
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(Modifier.padding(20.dp)) {
                    MyTittle("Requiere Autenticación")
                    Text("Para continuar, necesitas autenticarte de nuevo.")
                    Row(modifier =
                    Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Button(onClick = {disMiss()}) { Text("CANCELAR") }
                        Spacer(Modifier.padding(15.dp))
                        Button(onClick = {
                            disMiss()
                            cambiarTexto()
                        }) { Text("Autenticar")}
                    }
                }
            }
        }
    }

}
