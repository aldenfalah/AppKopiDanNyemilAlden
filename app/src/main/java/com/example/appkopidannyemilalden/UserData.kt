package com.example.appkopidannyemilalden

object UserData {
    var namaLengkap: String = ""
    var username: String = ""
    var password: String = ""

    fun isRegistered(): Boolean = username.isNotEmpty()
}