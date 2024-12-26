package com.example.wallpaper_app

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpaper_app.ui.theme.Wallpaper_AppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val Wallpaper_Name = "All Wallpaper"

        setContent {

            Wallpaper_AppTheme {

                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = ({
                            Text(
                                text = Wallpaper_Name,
                                fontSize = 25.sp,
                                color = Color.White, fontFamily = FontFamily(Font(R.font.moon))
                            )
                        }),
                        actions = {
                            Image(
                                painter = painterResource(R.drawable.pf),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(50.dp)
                                    .padding(7.dp)
                            )
                        },
                        navigationIcon = {
                            Icon(
                                painter = painterResource(R.drawable.option),
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier
                                    .height(45.dp)
                                    .width(50.dp)
                                    .padding(12.dp)
                                    .clickable {
                                        val intent =
                                            Intent(this@MainActivity, Dashboard::class.java)
                                        startActivity(intent)
                                    }
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)
                    )
                })
                { paddingValues ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                            .background(color = Color.Black)
                    ) {

                        Row(
                            modifier = Modifier
                                .height(20.dp)
                                .fillMaxWidth()
                        ) {

                        }

                        LazyVerticalGrid(columns = GridCells.Fixed(3)) {

                            items(Wallpaper.allImage.size) { index ->


                                Surface(
                                    modifier = Modifier
                                        .height(200.dp)
                                        .width(40.dp)
                                        .padding(3.dp),
                                    color = Color.Black
                                ) {

                                    Surface(
                                        modifier = Modifier
                                            .height(180.dp)
                                            .width(40.dp)
                                            .fillMaxSize()
                                            .padding(1.dp),
                                        color = Color.Black, shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Image(
                                            painter = painterResource(Wallpaper.allImage[index]),
                                            contentDescription = null,
                                            contentScale = ContentScale.FillBounds,
                                            modifier = Modifier.clickable {

                                                val intent =
                                                    Intent(
                                                        this@MainActivity,
                                                        ShowPage::class.java
                                                    )

                                                intent.putExtra("allname" , Wallpaper_Name)
                                                intent.putExtra("all" , Wallpaper.allImage[index])

                                                Log.d(
                                                    "===>",
                                                    "onCreate: ${Wallpaper.allImage[index]}"
                                                )

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

