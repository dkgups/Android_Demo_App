package android.com.myapplication.ui.splash

import android.com.myapplication.R
import android.com.myapplication.ui.home.FactsActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({
            startActivity(Intent(this, FactsActivity::class.java))
            finish()

        },3000)
    }
}
