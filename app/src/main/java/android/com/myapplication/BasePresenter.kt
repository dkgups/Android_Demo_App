package android.com.myapplication

import android.view.View

interface BasePresenter<T> {
    fun takeView(view: T?)
    fun dropView()
}