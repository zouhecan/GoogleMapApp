package com.example.googlemapapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment_test.*

/**
 * desc:
 * author: zouhecan {hc.zou@ctrip.com}
 * date: 2020/4/28
 */
class FragmentTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_test)
        val fragment = TestFragment1("test fragment 1")
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootView, fragment)
            .commit()
        rootView.setOnClickListener {
            startActivity(Intent(this, FragmentTestActivity::class.java))
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("zouhecan", intent.toString())
    }
}