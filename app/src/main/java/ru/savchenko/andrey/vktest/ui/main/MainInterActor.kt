package ru.savchenko.andrey.vktest.ui.main

import io.reactivex.Single
import ru.savchenko.andrey.vktest.entities.Item
import ru.savchenko.andrey.vktest.entities.VKResponse
import ru.savchenko.andrey.vktest.network.NetworkHandler
import ru.savchenko.andrey.vktest.storage.Storage
import ru.savchenko.andrey.vktest.storage.Validator

/**
 * Created by savchenko on 25.04.18.
 */
class MainInterActor {
    fun getNews(ownerId: String): Single<List<Item>> {
        return NetworkHandler.getService().getNews(Storage.token, "5.74", ownerId)
                .compose(Validator())
                .map { t: VKResponse? -> t?.response?.items }
    }
}