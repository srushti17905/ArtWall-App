// shared/src/iosMain/kotlin/com/example/share/ShareServiceImpl.kt
package com.example.my_shayari_app

import platform.UIKit.UIApplication
import platform.UIKit.UIActivityViewController
import platform.Foundation.NSArray

actual class ShareService actual constructor(context : Any?) {
    actual fun shareText(text: String) {
        val viewController = UIApplication.sharedApplication.keyWindow?.rootViewController
        val activityViewController = UIActivityViewController(activityItems = NSArray(array = arrayOf(text)), applicationActivities = null)

        viewController?.presentViewController(activityViewController, animated = true, completion = null)
    }
    actual fun shareTextToWhatsApp(text: String) {
        val urlString = "whatsapp://send?text=${NSString.stringWithString(text).stringByAddingPercentEncodingWithAllowedCharacters(NSCharacterSet.URLQueryAllowedCharacterSet)}"
        val url = NSURL.URLWithString(urlString)

        if (UIApplication.sharedApplication.canOpenURL(url)) {
            UIApplication.sharedApplication.openURL(url)
        } else {
            // Handle case where WhatsApp is not installed
        }
    }
    actual fun copyText(text: String) {
        override fun copyToClipboard(text: String) {
            UIPasteboard.generalPasteboard.string = text
        }
    }
}