package com.example.wallpaper_app

import android.app.WallpaperManager
import android.content.res.Resources.Theme
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toBitmap
import com.example.wallpaper_app.ui.theme.Wallpaper_AppTheme

class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wallpaper_AppTheme {

                demo()

            }
        }
    }
}

@Composable
@Preview

fun demo() {

    val context = LocalContext.current
    val wallpaperManager = WallpaperManager.getInstance(context)


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Row(
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.nature1),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
        ) {

            Button(
                onClick = {

                    val bitmap = context.resources.getDrawable(R.drawable.nature1).toBitmap()

                    try {
                        wallpaperManager
                            .setBitmap(bitmap)
                    } catch (e: Exception) {
                        Log.d("===error===", "setWallpaper: ${e.localizedMessage}")
                    }

                }, modifier = Modifier
                    .height(100.dp)
                    .width(180.dp)
            ) {

                Text(text = "wallpaper", fontSize = 20.sp, color = Color.Black)

            }

        }

    }

}