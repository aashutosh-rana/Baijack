package com.bcebhagalpur.baijack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {

    private lateinit var txt:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt=findViewById(R.id.txt)

        if (!Python.isStarted()){
            Python.start(AndroidPlatform(this))
            val py=Python.getInstance()
            val pyObject=py.getModule("HelloWorld")
           val tetx= pyObject.callAttr("my_function",4,5)
            txt.text= tetx.toString()

        }
    }
}