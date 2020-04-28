package com.example.googlemapapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment_test.*

/**
 * desc:
 * author: zouhecan {zouhecan@gmail.com}
 * date: 2020/4/28
 */
class FragmentTestActivity : AppCompatActivity() {
    private var index = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("zouhecan", "onCreate: $index")
        setContentView(R.layout.activity_fragment_test)
        val fragment = TestFragment2("test fragment $index")
        supportFragmentManager.beginTransaction()
            .replace(R.id.rootView, fragment)
            .commit()
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
        index++
        Thread.currentThread().uncaughtExceptionHandler =
            Thread.UncaughtExceptionHandler { _: Thread?, e: Throwable ->
                e.printStackTrace()
                Log.e("zouhecan", "crash: ${e.message}")
            }
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.d("zouhecan", "onNewIntent: $index")
    }

    override fun onPause() {
        super.onPause()
        Log.d("zouhecan", "onPause: $index")
    }

    override fun onStop() {
        super.onStop()
        Log.d("zouhecan", "onStop: $index")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zouhecan", "onDestroy: $index")
    }
}