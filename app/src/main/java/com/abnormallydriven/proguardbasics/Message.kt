package com.abnormallydriven.proguardbasics

data class Message(val contents: String) {

    override fun toString(): String {
        return contents
    }
}