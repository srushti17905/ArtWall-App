package com.example.wallpaper_app

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpaper_app.ui.theme.Wallpaper_AppTheme
import java.io.ByteArrayOutputStream

class ViewPage : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewName = intent.getStringExtra("name")

            val view = if (viewName == "Nature") {

                Wallpaper.nature

            } else if (viewName == "Artistic") {

                Wallpaper.artistic

            } else if (viewName == "Food") {

                Wallpaper.Food

            } else if (viewName == "Sanatan Dharma") {

                Wallpaper.god

            } else if (viewName == "Mountain") {

                Wallpaper.Mountain

            } else if (viewName == "Cute") {

                Wallpaper.cute

            } else if (viewName == "Night") {

                Wallpaper.night

            } else if (viewName == "Spring") {

                Wallpaper.Spring

            } else if (viewName == "Music") {

                Wallpaper.Music

            } else if (viewName == "Girly") {

                Wallpaper.Girly

            } else if (viewName == "Animal") {

                Wallpaper.Animal

            } else if (viewName == "Ocean") {

                Wallpaper.Ocean

            } else if (viewName == "Birds") {

                Wallpaper.Birds

            } else if (viewName == "City & Building") {

                Wallpaper.City

            } else if (viewName == "Quotes") {

                Wallpaper.quotes

            } else if (viewName == "Astronaut") {

                Wallpaper.astronaut

            } else if (viewName == "Love") {

                Wallpaper.Love

            } else if (viewName == "Flower") {

                Wallpaper.Flower

            } else if (viewName == "Moon") {

                Wallpaper.Moon

            } else if (viewName == "Travel") {

                Wallpaper.travel

            } else if (viewName == "Black & White") {

                Wallpaper.BlackWhite

            } else if (viewName == "Sun") {

                Wallpaper.Sun

            } else if (viewName == "Anime") {

                Wallpaper.Anime

            } else if (viewName == "Classic") {

                Wallpaper.classic

            } else {

                Wallpaper.Birds
            }



            Wallpaper_AppTheme {

                Scaffold(topBar = {
                    CenterAlignedTopAppBar(title = {
                        if (viewName != null) {
                            Text(
                                text = viewName,
                                fontSize = 33.sp,

                                color = Color.White, fontFamily = FontFamily(Font(R.font.moon))
                            )
                        } else {

                            Text(
                                text = "Wallpaper",
                                fontSize = 33.sp,
                                color = Color.White,
                                fontFamily = FontFamily(
                                    Font(R.font.moon)
                                )
                            )

                        }

                    },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                        navigationIcon = {
                            Icon(
                                painter = painterResource(R.drawable.arrow),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(30.dp)
                                    .padding(5.dp)
                                    .clickable {

                                        val intent = Intent(this@ViewPage, Category::class.java)
                                        startActivity(intent)

                                    }
                                    .width(40.dp), tint = star.light_background
                            )
                        },
                        actions = {
                            Image(
                                painter = painterResource(R.drawable.pf),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(50.dp)
                                    .padding(5.dp)
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

                        LazyVerticalGrid(columns = GridCells.Fixed(3)) {

                            items(20) { index ->

                                Surface(
                                    modifier = Modifier
                                        .height(200.dp)
                                        .padding(3.dp)
                                        .width(50.dp)
                                ) {
                                    Surface(
                                        modifier = Modifier
                                            .width(40.dp)
                                            .height(180.dp)
                                            .padding(1.dp), shape = RoundedCornerShape(10.dp)
                                    ) {

                                        Image(
                                            painter = painterResource(view[index]),
                                            contentDescription = null,
                                            contentScale = ContentScale.FillBounds,
                                            modifier = Modifier.clickable {

                                                val intent =
                                                    Intent(
                                                        this@ViewPage,
                                                        ShowPage::class.java
                                                    ).apply {


                                                        putExtra("view", viewName)
                                                        putExtra("Nature", Wallpaper.nature[index])
                                                        putExtra(
                                                            "Artistic",
                                                            Wallpaper.artistic[index]
                                                        )
                                                        putExtra("Food", Wallpaper.Food[index])
                                                        putExtra("God", Wallpaper.god[index])
                                                        putExtra(
                                                            "Mountain",
                                                            Wallpaper.Mountain[index]
                                                        )
                                                        putExtra("Cute", Wallpaper.cute[index])
                                                        putExtra("Night", Wallpaper.night[index])
                                                        putExtra("Spring", Wallpaper.Spring[index])
                                                        putExtra("Music", Wallpaper.Music[index])
                                                        putExtra("Girly", Wallpaper.Girly[index])
                                                        putExtra("Animal", Wallpaper.Animal[index])
                                                        putExtra("Ocean", Wallpaper.Ocean[index])
                                                        putExtra("Birds", Wallpaper.Birds[index])
                                                        putExtra("city", Wallpaper.City[index])
                                                        putExtra("quote", Wallpaper.quotes[index])
                                                        putExtra(
                                                            "Astronaut",
                                                            Wallpaper.astronaut[index]
                                                        )
                                                        putExtra("Love", Wallpaper.Love[index])
                                                        putExtra("Flower", Wallpaper.Flower[index])
                                                        putExtra("Moon", Wallpaper.Moon[index])
                                                        putExtra("Travel", Wallpaper.travel[index])
                                                        putExtra("Bw", Wallpaper.BlackWhite[index])
                                                        putExtra("sun", Wallpaper.Sun[index])
                                                        putExtra("Anime", Wallpaper.Anime[index])
                                                        putExtra(
                                                            "Classic",
                                                            Wallpaper.classic[index]
                                                        )

                                                    }

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
}

