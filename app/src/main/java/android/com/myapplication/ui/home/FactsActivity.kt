package android.com.myapplication.ui.home

import android.com.myapplication.R

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

class FactsActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }
}
