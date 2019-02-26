package com.captis.basemodule.callbacks

import retrofit2.Response

interface GetAPIResultCallback<T> {

    fun onGetResponse(response: Response<T>)
    fun onGetFailure()

}