package ru.savchenko.andrey.vktest.base

import com.arellomobile.mvp.MvpPresenter
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import retrofit2.Response

/**
 * Created by savchenko on 10.04.18.
 */
open class BasePresenter<T : BaseView> : MvpPresenter<T>() {

    fun <T> corMethod(beforeRequest: () -> Unit = { showDialog() },
                      afterRequest: () -> Unit = { hideDialog() },
                      request: () -> Response<T>,
                      onResult: (result: T) -> Unit,
                      errorShow: (error: String) -> Unit = { t -> showError(t) }): Job {
        return launch(UI) {
            beforeRequest()
            var result: Response<T>? = null
            try {
                result = async(CommonPool) { request() }.await()
            } catch (ex: Throwable) {
                ex.printStackTrace()
                errorShow(ex.message.toString())
            }
            afterRequest()

            if (result != null) {
                if (result.body() != null) {
                    val body = result.body()
                    body?.let { onResult(it) }
                } else {
                    errorShow("responseBody = null")
                }
            } else {
                errorShow("result = null")
            }
        }
    }


    fun showDialog() {
        viewState.showDialog()
    }

    fun hideDialog() {
        viewState.hideDialog()
    }

    fun showError(error: String) {
        viewState.showError(error)
    }
}