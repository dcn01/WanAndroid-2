package com.xiamu.wanandroid.mvvm.model.entry

/**
 * Created by zhengxiaobo in 2019-10-29
 */
data class WanResponse<out T>(val errorcode: Int, val errMsg: String, val data: T)