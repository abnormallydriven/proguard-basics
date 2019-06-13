package com.abnormallydriven.proguardbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clazz = Class.forName("com.abnormallydriven.proguardbasics.Message")
        val constructor = clazz.getConstructor(String::class.java)

        val myReflectedMessage = constructor.newInstance("My Message String")
        Log.d("ProguardBasics", myReflectedMessage.toString())

    }
}
