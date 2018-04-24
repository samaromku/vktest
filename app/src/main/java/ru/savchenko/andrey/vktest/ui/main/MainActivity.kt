package ru.savchenko.andrey.vktest.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import ru.savchenko.andrey.vktest.R
import ru.savchenko.andrey.vktest.base.BaseActivity
import ru.savchenko.andrey.vktest.storage.Storage

class MainActivity : BaseActivity(), MainView {
    @InjectPresenter
    lateinit var presenter: MainPresenter
    private val scopeList = listOf<String>(VKScope.GROUPS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        VKSdk.login(this, VKScope.WALL, VKScope.FRIENDS)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
            override fun onError(error: VKError?) {
                Toast.makeText(this@MainActivity, error.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onResult(res: VKAccessToken?) {
                Storage.token = res
                presenter.getNews()
            }
        })
    }
}
