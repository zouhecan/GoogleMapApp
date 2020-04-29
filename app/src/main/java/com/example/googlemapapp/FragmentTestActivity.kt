package com.example.googlemapapp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_test.*
import java.lang.Exception

/**
 * desc:
 * author: zouhecan {zouhecan@gmail.com}
 * date: 2020/4/28
 */
class FragmentTestActivity : AppCompatActivity() {
    private var index = 1
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)//
        Log.d("zouhecan", "Activity onCreate: $index")
        setContentView(R.layout.activity_fragment_test)
        if (savedInstanceState != null) {
            return
        }
        fragment = TestFragment3.newInstance("test fragment $index")
        supportFragmentManager.beginTransaction()
            .add(R.id.rootView, fragment)
            .commit()
        index++
//        val fragment2 = TestFragment2("test fragment $index")
//        supportFragmentManager.beginTransaction()
//            .add(R.id.rootView, fragment2)
//            .addToBackStack("fragment2")
//            .commit()
        rootView.setOnClickListener {
            val urls = ArrayList(
                mutableListOf(
//                    "https://help.github.com/cn/github/using-git/resolving-merge-conflicts-after-a-git-rebase",
//                    "https://juejin.im/entry/5ae9706d51882567327809d0",
//                    "https://juejin.im/entry/5ae9706d51882567327809d0",
//                    "https://zhuanlan.zhihu.com/p/32536915"
                    "http://tshop.xymens.com/Assets/cat_size/?table_id=5&goods_id=277063&user_id="
                )
            )
            startActivity(Intent(this, WebViewActivity::class.java).apply {
                putStringArrayListExtra("URLS", urls)
            })
            Log.d("zouhecan", "startWebViewActivity")
        }
        Thread.currentThread().uncaughtExceptionHandler =
            Thread.UncaughtExceptionHandler { _: Thread?, e: Throwable ->
                e.printStackTrace()
                Log.e("zouhecan", "crash: ${e.message}")
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d("zouhecan", "Activity onSaveInstanceState")
        super.onSaveInstanceState(outState)
        //验证commit 与 commitAllowLossState区别
        try {
            supportFragmentManager.beginTransaction()
                .replace(R.id.rootView, fragment)
                .commit()
        } catch (e: Exception) {
            Log.d("zouhecan", "Can not perform this action after onSaveInstanceState")
        }
        //没有异常
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootView, fragment)
            .commitAllowingStateLoss()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("zouhecan", "Activity onRestoreInstanceState: $index")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("zouhecan", "Activity onNewIntent: $index")
    }

    override fun onPause() {
        super.onPause()
        Log.d("zouhecan", "Activity onPause: $index")
    }

    override fun onStop() {
        super.onStop()
        Log.d("zouhecan", "Activity onStop: $index")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zouhecan", "Activity onDestroy: $index")
    }

    private fun addTestFragment() {
        //先看viewContainer中是否存在fragment
        val fragment =
            if (supportFragmentManager.findFragmentById(R.id.fragmentContainer) == null) {
                supportFragmentManager.findFragmentById(R.id.fragmentContainer) as TestFragment4
            } else {
                TestFragment4()
            }.apply {
                //实例值传递
                setType("科学添加fragment")
            }
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootView, fragment)
            .commitAllowingStateLoss()
    }
}