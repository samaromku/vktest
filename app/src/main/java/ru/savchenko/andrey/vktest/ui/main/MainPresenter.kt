package ru.savchenko.andrey.vktest.ui.main

import com.arellomobile.mvp.InjectViewState
import ru.savchenko.andrey.vktest.base.BasePresenter
import ru.savchenko.andrey.vktest.network.NetworkHandler
import ru.savchenko.andrey.vktest.storage.Storage

/**
 * Created by Andrey on 24.04.2018.
 */
@InjectViewState
class MainPresenter:BasePresenter<MainView>() {
    fun getNews(){
        Storage.token?.accessToken?.let {
            corMethod(request = { NetworkHandler.getService().getNews(it).execute() },
                    onResult = {result ->
                        println(result)
                    })
        }

    }
}