// shared/src/androidMain/kotlin/com/example/share/ShareServiceImpl.kt
package com.example.my_shayari_app

import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.content.Intent.createChooser
import android.util.Log
import android.content.ClipData
import android.content.ClipboardManager as AndroidClipboardManager
import android.content.Context
import android.widget.Toast


actual class ShareService actual constructor(context: Any?) {
    actual fun shareText(text: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        val shareIntent = createChooser(sendIntent, null)
        (context as Context).startActivity(shareIntent)
    }

    actual fun shareTextToWhatsApp(text: String) {
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
            setPackage("com.whatsapp") // Specify WhatsApp package
        }
        (context as Context).startActivity(intent)

    }
    actual fun copyText(text: String) {
        val clipboard = (context as Context).getSystemService(Context.CLIPBOARD_SERVICE) as AndroidClipboardManager
        val clip = ClipData.newPlainText("Copied Text", text)
        clipboard.setPrimaryClip(clip)
    }

}



