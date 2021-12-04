package com.ved.lifecycledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.*
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val Key:String = "keystring"
    }
    private var counter: Int = 0
    lateinit var textView: TextView
    lateinit var button: Button

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        d("TAG","onSaveInstanceState")
        outState.putInt(Key,counter)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        d("TAG", "onRestoreInstanceState")
        counter = savedInstanceState.getInt(Key)
        textView.text = "Counter: $counter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        d("TAG","onCreate")
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        if(savedInstanceState!=null){
            counter = savedInstanceState.getInt(Key) 
        }
        button.setOnClickListener {
            counter++
            textView.text = "Counter: $counter"
        }
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