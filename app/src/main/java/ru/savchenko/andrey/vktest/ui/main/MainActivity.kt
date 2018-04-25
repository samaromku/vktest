package ru.savchenko.andrey.vktest.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import kotlinx.android.synthetic.main.activity_main.*
import ru.savchenko.andrey.vktest.R
import ru.savchenko.andrey.vktest.base.BaseActivity
import ru.savchenko.andrey.vktest.base.OnItemClickListener
import ru.savchenko.andrey.vktest.entities.Item
import ru.savchenko.andrey.vktest.storage.Storage

class MainActivity : BaseActivity(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSdk()
        ivSend.setOnClickListener {
            presenter.getNews(etGroupId.text.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
            override fun onError(error: VKError?) {
                Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResult(res: VKAccessToken?) {
                Storage.token = res?.accessToken.toString()
            }
        })
    }

    fun initSdk() {
        if(Storage.token.isEmpty()) {
            VKSdk.login(this, VKScope.WALL, VKScope.FRIENDS)
        }
    }

    override fun setListToAdapter(list: MutableList<Item>) {
        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = MainAdapter(list, object :OnItemClickListener{
            override fun onClick(position: Int) {
                println(position)
            }
        })
    }
}
