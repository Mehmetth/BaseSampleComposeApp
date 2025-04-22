package com.mehmetpetek.basesampleapp.app

import android.app.Application
import androidx.compose.runtime.Stable
import dagger.hilt.android.HiltAndroidApp

@Stable
@HiltAndroidApp
class BaseSampleApp : Application()