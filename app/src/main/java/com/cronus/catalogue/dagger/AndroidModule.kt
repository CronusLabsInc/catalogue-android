package com.cronus.catalogue.dagger

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AndroidModule(private val context: Context) {

    @Provides
    fun context() = context

}