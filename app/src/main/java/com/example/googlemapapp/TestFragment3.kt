package com.example.googlemapapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_test_1.*
import java.lang.Exception

/**
 * desc:
 * author: zouhecan {zouhecan@gmail.com}
 * date: 2020/4/28
 */
class TestFragment3() : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance(type: String): TestFragment3 {
            return TestFragment3().apply {
                arguments = Bundle().apply { putString("TYPE", type) }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_test_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("TYPE")?.let {
            Log.d("zouhecan", "TestFragment onViewCreated: type = $it")
            content.text = it
        }
        showParent()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        childFragmentManager.beginTransaction()
//            .add(R.id.fragmentContainer, TestFragment2())
//            .addToBackStack("fragment2")
//            .commitAllowingStateLoss()
        try {
            if (null as Boolean) {
                Log.d("zouhecan", "TestFragment1 ：null can be cast to non-null type kotlin.Boolean")
            }
        } catch (e: Exception) {
            Log.d("zouhecan", "TestFragment1 ：null cannot be cast to non-null type kotlin.Boolean")
        }

        if (null as Boolean? == null) {
            Log.d("zouhecan", "TestFragment1 ：null can be cast to nullable type kotlin.Boolean?")
        } else {
            Log.d("zouhecan", "TestFragment1 ：null cannot be cast to nullable type kotlin.Boolean?")
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("zouhecan", "TestFragment1 ：onDetach")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("zouhecan", "TestFragment1 ：onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("zouhecan", "TestFragment1 ：onDestroy")
    }

    private fun showParent() {
        (view?.parent as ViewGroup?)?.visibility = View.VISIBLE
    }
}