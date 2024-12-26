package com.example.wallpaper_app

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Wallpaper_AppTheme {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                )
                {

                    Surface(modifier = Modifier.fillMaxSize()) {

                        Image(
                            painter = painterResource(R.drawable.wallback3),
                            contentDescription = null,
                            contentScale = ContentScale.FillBounds
                        )

                        Column(modifier = Modifier.fillMaxSize()) {

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.Bottom,
                                modifier = Modifier
                                    .height(160.dp)
                                    .fillMaxWidth()
                            ) {

                                Text(
                                    text = "Make Your Wallpaper More",

                                    fontSize = 20.sp,
                                    color = Color.White, fontFamily = FontFamily(Font(R.font.moon))
                                )

                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Beautiful",
                                    fontSize = 30.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.moon))
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .height(350.dp)
                                    .fillMaxWidth()
                            ) {

                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .height(60.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "Category",
                                    fontSize = 30.sp,
                                    color = Color.White,
                                    fontFamily = FontFamily(
                                        Font(R.font.moon)
                                    ), modifier = Modifier.clickable {

                                        val intent = Intent(this@Dashboard, Category::class.java)
                                        startActivity(intent)

                                    }
                                )
                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()
                            ) {
                                Text(
                                    text = "HomePage",
                                    fontSize = 30.sp,
                                    color = Color.Black,
                                    fontFamily = FontFamily(Font(R.font.moon)),
                                    modifier = Modifier.clickable {

                                        val intent =
                                            Intent(this@Dashboard, MainActivity::class.java)
                                        startActivity(intent)

                                    }
                                )
                            }

                            Row(
                                modifier = Modifier
                                    .height(50.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Favorite",
                                    fontSize = 30.sp,
                                    color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.moon)),
                                    modifier = Modifier.clickable {

                                        val intent = Intent(this@Dashboard, Favorite::class.java)
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

