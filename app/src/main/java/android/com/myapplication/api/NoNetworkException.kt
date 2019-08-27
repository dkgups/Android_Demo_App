package android.com.myapplication.api

import java.lang.RuntimeException

class NoNetworkException: RuntimeException("Please check your Internet Connection")
