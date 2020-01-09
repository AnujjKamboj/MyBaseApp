package com.example.mybaseapp.activity

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.mybaseapp.R
import com.example.mybaseapp.data.LoginEntity
import com.example.mybaseapp.data.SignUpWrapper
import com.example.mybaseapp.retrofir_repo.ApiInterface
import com.example.mybaseapp.retrofir_repo.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
    }
//    private fun hitLoginApi() {
//        val username = "abc"
//        val password = "abc123"
//        val deviceToken = "sadakbdasdkjasd1212"
//
//        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java, "", "")
//            val call = apiInterface.loginApi(LoginEntity(username, password, deviceToken))
//            call.enqueue(object : Callback<SignUpWrapper> {
//                override fun onResponse(call: Call<SignUpWrapper>, response: Response<SignUpWrapper>) {
//
//                    val signUpWrapper = response.body()
//                    if (signUpWrapper.code == 200) {
////                        baseActivity.store.save(AppConstants.DEVICE_TOKEN, signUpWrapper!!.data.deviceToken)
////                        baseActivity.saveProfileData(signUpWrapper!!.data)
////                        user_id = signUpWrapper!!.data.id
////                        baseActivity.store.saveString("settings", signUpWrapper!!.data.setting)
////                        baseActivity.store.saveString("is_auth", signUpWrapper!!.data.is_auth)
////                        if (TextUtils.isEmpty(signUpWrapper!!.data.quickboxId)) {
////                            quickBloxSignUp(signUpWrapper!!.data.email, signUpWrapper!!.data.username)
////                        } else {
////                            loginQuickBlox(AppConstants.QUICKBLOX_PASSWORD, signUpWrapper!!.data.email, 0)
////                        }
//                    } else {
////                        baseActivity.hideLoading()
////                        baseActivity.showMessage(signUpWrapper!!.message)
//                    }
//                }
//
//                override fun onFailure(call: Call<SignUpWrapper>, t: Throwable) {
////                    baseActivity.hideLoading()
//                    t.printStackTrace()
////                    baseActivity.showMessage(t.message)
//                }
//            })
//
//
//    }
}