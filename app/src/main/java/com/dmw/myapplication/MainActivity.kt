package com.dmw.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private val TAG = "MainActivity"

    companion object {

        lateinit var sRef: WeakReference<MainActivity>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sRef = WeakReference(this)
        setContentView(R.layout.activity_main)

        open_native.setOnClickListener(this)
        open_flutter.setOnClickListener(this)
        open_flutter_fragment.setOnClickListener(this)

    }


    override fun onClick(v: View) {

        val params = HashMap<String, String>()

        params["test1"] = "v_test1"
        params["test2"] = "v_test2"

        when (v.id) {
            R.id.open_native -> {
                PageRouter.openPageByUrl(this, PageRouter.NATIVE_PAGE_URL, params)
            }
            R.id.open_flutter -> {
                Log.d(TAG, "onClick: open_flutter")
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_PAGE_URL, params)
            }
            R.id.open_flutter_fragment -> {
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_FRAGMENT_PAGE_URL, params)
            }
        }
    }
}
