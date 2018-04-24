package ru.savchenko.andrey.vktest

import android.app.Application
import com.vk.sdk.VKSdk

/**
 * Created by Andrey on 24.04.2018.
 */
class App:Application() {
    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(this)
    }
}