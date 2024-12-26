package com.example.wallpaper_app

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.GridView
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
import androidx.compose.foundation.lazy.grid.items
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wallpaper_app.ui.theme.Wallpaper_AppTheme


class Category : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val CategoryName = arrayOf(

                "Nature",
                "Artistic",
                "Food",
                "Sanatan Dharma",
                "Mountain",
                "Cute",
                "Night",
                "Spring",
                "Music",
                "Girly",
                "Animal",
                "Ocean",
                "Birds",
                "City & Building",
                "Quotes",
                "Astronaut",
                "Love",
                "Flower",
                "Moon",
                "Travel",
                "Black & White",
                "Sun",
                "Anime",
                "Classic"

            )


            val CategoryImage = arrayOf(
                R.drawable.nature,
                R.drawable.artistic,
                R.drawable.food,
                R.drawable.om1,
                R.drawable.mountain,
                R.drawable.cute,

                R.drawable.night,
                R.drawable.spring,
                R.drawable.music,
                R.drawable.girly1,
                R.drawable.animal,

                R.drawable.ocean,
                R.drawable.birds,
                R.drawable.cityandbuiding,
                R.drawable.quetos,
                R.drawable.astronaut,

                R.drawable.love,
                R.drawable.flower,
                R.drawable.moon,
                R.drawable.travel,
                R.drawable.blackandwhite,

                R.drawable.sun,
                R.drawable.anime,
                R.drawable.classic,
            )

            Wallpaper_AppTheme {

                Scaffold(topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            (Text(
                                text = "Category",
                                fontSize = 35.sp,
                                color = Color.White, fontFamily = FontFamily(Font(R.font.moon))
                            ))
                        },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                        navigationIcon = {
                            Icon(
                                painter = painterResource(R.drawable.arrow),
                                contentDescription = null,
                                tint = star.light_background,
                                modifier = Modifier
                                    .height(42.dp)
                                    .padding(10.dp)
                                    .width(30.dp)
                                    .clickable {
                                        val intent = Intent(this@Category, Dashboard::class.java)
                                        startActivity(intent)
                                        finish()
                                    }
                            )
                        },
                        actions = {
                            Image(
                                painter = painterResource(R.drawable.pf),
                                contentDescription = null , modifier = Modifier.height(50.dp).padding(5.dp)
                            )
                        },
                    )
                }) { paddingValues ->

                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                            .background(Color.Black)
                    ) {

                        Row(
                            modifier = Modifier
                                .height(20.dp)
                                .fillMaxWidth()
                        ) {

                        }

                        LazyVerticalGrid(columns = GridCells.Fixed(1))
                        {
                            items(CategoryImage.size) { index ->

                                Surface(
                                    modifier = Modifier
                                        .height(200.dp)
                                        .fillMaxWidth()
                                        .padding(8.dp),
                                    color = star.light_background,
                                    shape = RoundedCornerShape(10.dp)
                                ) {

                                    Surface(
                                        modifier = Modifier
                                            .height(180.dp)
                                            .fillMaxWidth()
                                            .padding(2.dp),
                                        shape = RoundedCornerShape(10.dp)
                                    ) {

                                        Image(
                                            painter = painterResource(CategoryImage[index]),
                                            contentDescription = null,
                                            contentScale = ContentScale.FillBounds,
                                            modifier = Modifier
                                                .alpha(.6f)
                                                .clickable {

                                                    val intent =
                                                        Intent(this@Category, ViewPage::class.java)

                                                    intent.putExtra("name", CategoryName[index])

                                                    Log.d(
                                                        "==category====",
                                                        "onCreate: ${CategoryName[index]}]"
                                                    )
                                                    startActivity(intent)
                                                }
                                        )

                                        Box(contentAlignment = Alignment.Center) {

                                            Text(
                                                text = CategoryName[index],
                                                fontSize = 30.sp,
                                                color = Color.White,
                                                fontFamily = FontFamily(Font(R.font.star))
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
}

