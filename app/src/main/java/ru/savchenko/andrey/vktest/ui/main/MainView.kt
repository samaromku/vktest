package ru.savchenko.andrey.vktest.ui.main

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.savchenko.andrey.vktest.base.BaseView
import ru.savchenko.andrey.vktest.entities.Item

/**
 * Created by Andrey on 24.04.2018.
 */
@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView :BaseView{
    fun setListToAdapter(list: MutableList<Item>)
}