package com.abnormallydriven.proguardbasics.messaging

import androidx.annotation.Keep

@Keep
data class Message(val contents: String) {

    override fun toString(): String {
        return contents
    }
}