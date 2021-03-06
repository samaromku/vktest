package ru.savchenko.andrey.vktest.ui.main

import com.arellomobile.mvp.InjectViewState
import ru.savchenko.andrey.vktest.base.BasePresenter

/**
 * Created by Andrey on 24.04.2018.
 */
@InjectViewState
class MainPresenter : BasePresenter<MainView>() {
    private val interActor = MainInterActor()
    fun getNews(ownerId: String) {
        if (ownerId.isNotEmpty()) {
            interActor.getNews(ownerId)
                    .compose(DialogTransformer())
                    .subscribe({ list ->
                        viewState.setListToAdapter(list.toMutableList())
                    },
                            { t ->
                                t.printStackTrace()
                                showError(t.message.toString())
                            })
        } else {
            viewState.showToast("Заполните id группы")
        }
    }
}