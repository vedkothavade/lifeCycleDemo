package com.ved.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.util.Log.*
import android.view.View
import android.widget.TextView
import kotlin.coroutines.ContinuationInterceptor

class MainActivity : AppCompatActivity() {
    companion object {
        const val Key:String = "sdafasd"
        const val textView

    }
    var counter:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text)

        //if (counter != null) {
            textView.setOnClickListener {
                counter = counter!! + 1
                textView.text = "Counter: $counter"
            }
       // }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        d("TAG", "onRestoreInstanceState")
        counter = savedInstanceState.getInt(Key)
        textView.text="Counter: " + counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt(Key,counter)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        d("TAG","onCreate")
    }

    override fun onStart() {
        super.onStart()
        d("TAG","onStart")
    }

    override fun onResume() {
        super.onResume()
        d("TAG","onResume")
    }

    override fun onPause() {
        super.onPause()
        d("TAG","onPause")
    }

    override fun onStop() {
        super.onStop()
        d("TAG","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        d("TAG","onDestroy")
    }


}