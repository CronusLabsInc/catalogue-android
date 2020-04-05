package com.cronus.catalogue

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.cronus.catalogue.dagger.AndroidModule
import com.cronus.catalogue.dagger.AppComponent
import com.cronus.catalogue.dagger.DaggerAppComponent

class CatalogueApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
    }

    fun initDagger(mainActivity: MainActivity) {
        appComponent = DaggerAppComponent.builder()
            .androidModule(AndroidModule(mainActivity))
            .build()
    }

}

fun FragmentActivity.injector(): AppComponent {
    return (application as CatalogueApplication).appComponent
}