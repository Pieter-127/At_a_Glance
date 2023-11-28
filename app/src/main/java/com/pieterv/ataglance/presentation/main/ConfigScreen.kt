package com.pieterv.ataglance.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.glance.appwidget.updateAll
import com.pieterv.ataglance.R
import com.pieterv.ataglance.presentation.component.Animation
import com.pieterv.ataglance.presentation.widget.QuoteWidget

@Composable
fun ConfigScreen() {
    UpdateWidgetContent()
    ConfigScreenContent()
}

@Composable
private fun UpdateWidgetContent() {
    val context = LocalContext.current
    LaunchedEffect(key1 = context) {
        QuoteWidget().updateAll(context)
    }
}

@Preview
@Composable
fun ConfigScreenPreview() {
    ConfigScreenContent()
}

@Composable
fun ConfigScreenContent() {
    Surface(color = MaterialTheme.colorScheme.background) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                ) {
                    Spacer(Modifier.height(96.dp))
                    Text(
                        text = stringResource(id = R.string.quote),
                        fontSize = 40.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(Modifier.height(8.dp))
                    Divider(
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 32.dp)
                    )
                    Spacer(Modifier.height(16.dp))
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 32.dp)
            ) {
                Animation()
            }
        }
    }
}