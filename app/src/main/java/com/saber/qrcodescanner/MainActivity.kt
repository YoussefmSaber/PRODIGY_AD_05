package com.saber.qrcodescanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanOptions
import com.saber.qrcodescanner.componants.CodeScannerScreen
import com.saber.qrcodescanner.componants.LinkifyText
import com.saber.qrcodescanner.componants.ScanButton
import com.saber.qrcodescanner.ui.theme.QRCodeScannerTheme

class MainActivity : ComponentActivity() {

    private lateinit var barcodeLauncher: ActivityResultLauncher<ScanOptions>

    override fun onCreate(savedInstanceState: Bundle?) {
        val scanResult = mutableStateOf("")
        barcodeLauncher = registerForActivityResult(ScanContract()) {
            scanResult.value = it.contents
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            QRCodeScannerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CodeScannerScreen(
                        innerPadding, barcodeLauncher, scanResult
                    )
                }
            }
        }
    }
}