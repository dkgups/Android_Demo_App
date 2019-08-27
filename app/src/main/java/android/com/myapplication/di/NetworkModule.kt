package android.com.myapplication.di

import android.com.myapplication.api.ApiConstant
import android.com.myapplication.api.ApiService
import android.com.myapplication.api.LiveNetworkMonitor
import android.com.myapplication.api.NetworkMonitor
import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {


    @Singleton
    @Provides
    fun provideApiService(okHttpClient: OkHttpClient.Builder): ApiService {
        return retrofit2.Retrofit.Builder()
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(ApiConstant.BASE_URL)
            .build()
            .create(ApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideOkhttpBuilder(networkMonitor: NetworkMonitor, context: Context): OkHttpClient.Builder {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)
        val okHttpBuilder = OkHttpClient.Builder()
        return okHttpBuilder.apply {
            cache(myCache)
            readTimeout(40, TimeUnit.SECONDS)
            writeTimeout(40, TimeUnit.SECONDS)
            addInterceptor { chain ->
                val request = chain.request()
                if (networkMonitor.isConnected()) {
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                    return@addInterceptor chain.proceed(request)
                } else {
                    request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                    chain.proceed(request)
                }
            }
        }

    }


    @Singleton
    @Provides
    fun networkMonitor(context: Context): NetworkMonitor = LiveNetworkMonitor(context)

}