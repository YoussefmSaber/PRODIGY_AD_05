package com.saber.qrcodescanner.componants

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun ScanButton(
    barcodeLauncher: ActivityResultLauncher<ScanOptions>,
    value: String,
    onButtonClicked: () -> Unit
) {
    ElevatedButton(
        onClick = onButtonClicked,
        shape = RoundedCornerShape(8.dp)
    ) {
        if (value != "")
            Text(
                "Scan another code",
                fontSize = 16.sp
            )
        else
            Text(
                "Scan code",
                fontSize = 16.sp
            )
    }
}