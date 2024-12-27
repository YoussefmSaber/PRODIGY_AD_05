package com.saber.qrcodescanner.componants

import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.journeyapps.barcodescanner.ScanOptions

@Composable
fun CodeScannerScreen(
    innerPadding: PaddingValues,
    barcodeLauncher: ActivityResultLauncher<ScanOptions>,
    scanResult: MutableState<String>
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(
                innerPadding,
            )
    ) {
        LinkifyText(
            text = scanResult.value,
            color = Color.Black,
            fontSize = 18.sp
        )
        Spacer(Modifier.height(16.dp))
        ScanButton(
            barcodeLauncher,
            scanResult.value
        ) {
            val options = ScanOptions()
            options.setOrientationLocked(true)
            options.setDesiredBarcodeFormats(ScanOptions.QR_CODE) // setting the barcode format to Qr code
            barcodeLauncher.launch(options)  // launching the qr code scanner through the camera
        }
    }
}