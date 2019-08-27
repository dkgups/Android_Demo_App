package android.com.myapplication

interface BaseView {
    fun init()
    fun showErrorMsg(throwable: Throwable,apiType: String ="none")
    fun showSuccessMsg(any: Any){}
    fun showProgress(msg: String ="Please Wait"){}
    fun hideProgress(){}
}