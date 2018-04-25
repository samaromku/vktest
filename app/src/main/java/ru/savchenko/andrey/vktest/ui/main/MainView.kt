package ru.savchenko.andrey.vktest.ui.main

import ru.savchenko.andrey.vktest.base.BaseView
import ru.savchenko.andrey.vktest.entities.Item

/**
 * Created by Andrey on 24.04.2018.
 */
interface MainView :BaseView{
    fun setListToAdapter(list: MutableList<Item>)
    fun initSdk()
}