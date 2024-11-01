package com.example.hookingfish.util
import java.lang.Error
interface Login {

    interface ViewModelLogin  {

        fun login (email:String, password:String)

    }

    interface View {

        fun showProgress(enabled:Boolean)
        fun displayEmailFailure(@StringRes emailError:Int?)
        fun displayNameFailure(@StringRes nameError:Int?)
        fun displayPasswordFailure(@StringRes passwordError:Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message:String)
        fun onUserRegisted()

    interface View : BaseView <Presenter>{

        fun showProgress(enabled:Boolean)
        fun displayEmailFailure(@StringRes emailError:Int?)
        fun displayPasswordFailure(@StringRes passwordError:Int?)
        fun onUserAuthenticated()
        fun onUserUnauthorized(message:String)

    }
}

