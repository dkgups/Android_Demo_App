package android.com.myapplication.di

import android.com.myapplication.ui.home.FactsActivity
import android.com.myapplication.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MyActivityBuilder {

    @ContributesAndroidInjector()
    internal abstract fun SplashActivity(): SplashActivity

    @ContributesAndroidInjector()
     internal abstract fun mainActivity(): FactsActivity
}