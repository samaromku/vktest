package ru.savchenko.andrey.vktest.base

import com.arellomobile.mvp.MvpView


interface BaseView : MvpView {
    fun showError(error: String)
    fun changeToolbarTitle(title: String)
    /**
     * метод если нужно заблочить ui, к примеру получить данные и больше ничего
     */
    fun showDialog()

    fun hideDialog()
    fun showToast(text: String)
}