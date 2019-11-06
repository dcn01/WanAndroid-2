package com.xiamu.wanandroid.mvvm.view.activity

import androidx.lifecycle.Observer
import com.hss01248.dialog.StyledDialog
import com.xiamu.baselibs.base.BaseVmActivity
import com.xiamu.baselibs.util.toast
import com.xiamu.wanandroid.Constant.AppConstant
import com.xiamu.wanandroid.R
import com.xiamu.wanandroid.databinding.LoginBinding
import com.xiamu.wanandroid.mvvm.viewmodel.LoginViewModel
import com.xiamu.wanandroid.util.Preference
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by zhengxiaobo in 2019-11-03
 */
class LoginActivity : BaseVmActivity<LoginBinding, LoginViewModel>() {

    private var isLogin by Preference(AppConstant.LOGIN_KEY, false)

    override fun providerVMClass(): Class<LoginViewModel>? = LoginViewModel::class.java

    var _user: String by Preference(AppConstant.USER_NAME, "")
    var _password: String by Preference(AppConstant.USER_PASSWORD, "")

    override fun getLayoutResId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        tv_login.setOnClickListener {
            if (validate())
                mViewModel.login(et_login_username.text.toString(), et_login_password.text.toString())
        }
    }

    override fun initData() {

    }

    override fun startObserve() {
        super.startObserve()
        mViewModel.apply {
            _uistate.observe(this@LoginActivity, Observer {
                it.showLoading?.let {
                    showLoading()
                }

                it.showSuccess?.let {
                    isLogin = true
                    hideLoading()
                    _user = it.username
                    _password = it.password
                    finish()
                }

                it.showError?.let {
                    hideLoading()
                    toast(it)
                }

            })
        }

    }

    fun showLoading(){
        StyledDialog.updateLoadingMsg("正在登陆")
    }

    fun hideLoading(){
        StyledDialog.dismissLoading()
    }

    private fun validate(): Boolean{
        var valid = true
        var username: String = et_login_username.text.toString()
        var password: String = et_login_password.text.toString()

        if (username.isEmpty()) {
            et_login_username.error = "账号不能为空"
            valid = false
        }
        if (password.isEmpty()) {
            et_login_password.error = "密码不能为空"
            valid = false
        }
        return valid
    }


}