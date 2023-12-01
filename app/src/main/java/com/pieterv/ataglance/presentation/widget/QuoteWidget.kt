package com.pieterv.ataglance.presentation.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.GlanceModifier
import androidx.glance.action.actionStartActivity
import androidx.glance.action.clickable
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import com.pieterv.ataglance.MainActivity
import com.pieterv.ataglance.R

class QuoteWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            QuoteWidgetContent(GlanceModifier.fillMaxSize(), context)
        }
    }

    @Composable
    private fun QuoteWidgetContent(modifier: GlanceModifier = GlanceModifier, context: Context) {
        Column(
            modifier = modifier.background(R.color.white)
                .clickable(actionStartActivity<MainActivity>()),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = context.getString(R.string.quote),
                modifier = GlanceModifier.padding(12.dp)
            )
        }
    }
}