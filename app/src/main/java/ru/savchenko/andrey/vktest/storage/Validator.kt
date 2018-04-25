package ru.savchenko.andrey.vktest.storage

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.savchenko.andrey.vktest.entities.VKResponse

/**
 * Created by savchenko on 25.04.18.
 */
class Validator<T> : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { res ->
                    if(res is VKResponse){
                        if(res.error!=null){
                            return@flatMap Single.error<T>(Throwable(res.error.errorMsg))
                        }
                    }
                    return@flatMap Single.just(res)
                }
    }
}