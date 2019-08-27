package android.com.myapplication.di

import android.com.myapplication.MyApplication
import android.com.myapplication.schedulers.BaseScheduler
import android.com.myapplication.schedulers.Scheduler
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun provideContext(application: MyApplication): Context {
        return application.applicationContext

    }

    @Singleton
    @Provides
    fun baseSchedular(): BaseScheduler {

        return Scheduler()
    }
}