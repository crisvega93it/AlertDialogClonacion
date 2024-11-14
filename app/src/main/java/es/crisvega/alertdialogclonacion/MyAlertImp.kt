package es.crisvega.alertdialogclonacion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAlertImp(
    show: Boolean,
    disMiss: () -> Unit,
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
                Column(Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "warning"
                    )
                    MyTittle("Aviso Importante")
                    Text("Recuerda que los cambios realizados no se pueden deshacer.")
                    Row(modifier =
                    Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center) {
                        Button(onClick = {disMiss()}) { Text("Entendido") }
                    }
                }
            }
        }
    }

}