package com.example.my_shayari_app

expect class ShareService(context : Any?) {
    
    fun shareText(text: String)
    fun shareTextToWhatsApp(text: String)
    fun copyText(text: String)
    
}