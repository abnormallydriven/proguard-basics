package com.abnormallydriven.proguardbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.abnormallydriven.proguardbasics.messaging.Message

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clazz = Class.forName("com.abnormallydriven.proguardbasics.messaging.Message")
        val constructor = clazz.getConstructor(String::class.java)

        val myReflectedMessage = constructor.newInstance("My Message String")
        Log.d("ProguardBasics", myReflectedMessage.toString())

        usePartOfMessageSender()
    }

    private fun usePartOfMessageSender() {
        val clazz = Class.forName("com.abnormallydriven.proguardbasics.messaging.MessageSender")
        val constructor = clazz.getConstructor()
        val message = Message("Super Important Message")

        val myReflectedSender = constructor.newInstance()

        val sendMessageMethod = clazz.getDeclaredMethod("sendMessage", Message::class.java)
        sendMessageMethod.invoke(myReflectedSender, message)
    }
}
