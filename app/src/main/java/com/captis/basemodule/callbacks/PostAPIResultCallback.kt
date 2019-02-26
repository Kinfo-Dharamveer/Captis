package com.captis.basemodule.callbacks

import retrofit2.Response

interface PostAPIResultCallback<T> {

    fun onResponse(response: Response<T>)
    fun onFailure()

}