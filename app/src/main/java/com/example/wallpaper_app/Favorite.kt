package com.example.wallpaper_app

import android.content.Intent
import android.database.Cursor
import android.media.Image
import android.os.Build
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpaper_app.Favorite.Companion.likeImage
import com.example.wallpaper_app.ui.theme.Wallpaper_AppTheme

class Favorite : ComponentActivity() {

    companion object {

        lateinit var likeImage: Database

    }

    @RequiresApi(Build.VERSION_CODES.Q)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ArrayList<showImage>()

        enableEdgeToEdge()

        likeImage = Database(applicationContext)
        val name = "Your Favorite's"

        setContent {

            val alldata = viewImage()

            Wallpaper_AppTheme {

                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(
                            text = name,
                            fontSize = 25.sp,
                            color = Color.White, fontFamily = FontFamily(Font(R.font.moon))
                        )
                    },
                        actions = {
                            Icon(
                                painter = painterResource(R.drawable.like),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(30.dp)
                                    .padding(5.dp),
                                tint = star.red
                            )
                        })
                }) { paddingValues ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .background(color = Color.Black)
                    ) {

                        Row(
                            modifier = Modifier
                                .height(10.dp)
                                .fillMaxWidth()
                        ) {


                        }

                        LazyVerticalGrid(GridCells.Fixed(3)) {

                            items(alldata.size) { index ->

                                Surface(
                                    modifier = Modifier
                                        .height(200.dp)
                                        .width(100.dp)
                                        .padding(5.dp), shape = RoundedCornerShape(10.dp)
                                ) {

                                    Image(
                                        painter = painterResource(alldata[index].like),
                                        contentDescription = null,
                                        contentScale = ContentScale.FillBounds,
                                        modifier = Modifier.clickable {

                                            val intent = Intent(this@Favorite, ShowPage::class.java)

                                            intent.putExtra("favorite", alldata[index].like)
                                            intent.putExtra("favname" , name)

                                            startActivity(intent)

                                        }
                                    )

                                }

                            }

                        }


                    }

                }

            }
        }
    }
}

private fun viewImage(): ArrayList<fevorite> {

    val viewData = ArrayList<fevorite>()
    val cursor: Cursor = likeImage.readableDatabase.rawQuery("SELECT * FROM user", null)

    cursor.use {

        if (it.moveToFirst()) {

            do {

                val id = it.getInt(0)
                val like = it.getInt(1)

                val data = fevorite(id = id, like = like)
                viewData.add(data)

            } while (it.moveToNext())


        }
        return viewData

    }


}



