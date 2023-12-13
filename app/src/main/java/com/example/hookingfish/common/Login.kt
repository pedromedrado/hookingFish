package com.example.hookingfish.util

import androidx.annotation.StringRes

interface Login {

    interface ViewModelLogin  {

        fun login (email:String, password:String)

    }

    interface View : BaseView <Presenter>{

        fun showProgress(enabled:Boolean)
        fun displayEmailFailure(@StringRes emailError:Int?)
        fun displayPasswordFailure(@StringRes passwordError:Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message:String)
    }
}

