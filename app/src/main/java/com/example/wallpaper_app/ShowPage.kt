package com.example.wallpaper_app

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.wallpaper_app.ui.theme.Wallpaper_AppTheme
import java.io.IOException

class ShowPage : ComponentActivity() {

    companion object{

        fun setDrawableAsWallpaper(context: Context, drawableId: Int) {

            val drawable = ContextCompat.getDrawable(context, drawableId)
            val bitmap = Bitmap.createBitmap(
                drawable!!.intrinsicWidth,
                drawable.intrinsicHeight,
                Bitmap.Config.ARGB_8888
            )
            val canvas = android.graphics.Canvas(bitmap)
            drawable.setBounds(0, 0, canvas.width, canvas.height)
            drawable.draw(canvas)

            val wallpaperManager = WallpaperManager.getInstance(context)
            try {
                wallpaperManager.setBitmap(bitmap)
            } catch (e: IOException) {
                Toast.makeText(context, "Error setting wallpaper", Toast.LENGTH_SHORT).show()
            }
        }

    }


    object shareToWhatsapp {

        fun shareImageToWhatsapp(context: Context, drawableResId: Int) {

            val imageUri = getUriFromDrawableResource(context, drawableResId)

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "image/*"
                `package` = "com.whatsapp" // Set the package name for WhatsApp
                putExtra(Intent.EXTRA_STREAM, imageUri)
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }

            context.startActivity(Intent.createChooser(shareIntent, "Share Image"))
        }

        fun getUriFromDrawableResource(context: Context, drawableResId: Int): Uri {

            val resources = context.resources
            val resourceName = resources.getResourceEntryName(drawableResId)
            val resourcePackageName = resources.getResourcePackageName(drawableResId)
            val resourceTypeName = resources.getResourceTypeName(drawableResId)

            return Uri.parse("android.resource://$resourcePackageName/$resourceTypeName/$resourceName")
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {


            val setWallpaper = mutableStateOf(false)

            val name = intent.getStringExtra("view")
            val favname = intent.getStringExtra("favname")

            val nature = intent.getIntExtra("Nature", -1)
            val art = intent.getIntExtra("Artistic", -1)
            val food = intent.getIntExtra("Food", -1)
            val god = intent.getIntExtra("God", -1)
            val mountain = intent.getIntExtra("Mountain", -1)
            val cute = intent.getIntExtra("Cute", -1)
            val night = intent.getIntExtra("Night", -1)
            val spring = intent.getIntExtra("Spring", -1)
            val music = intent.getIntExtra("Music", -1)
            val girly = intent.getIntExtra("Girly", -1)
            val animal = intent.getIntExtra("Animal", -1)
            val ocean = intent.getIntExtra("Ocean", -1)
            val birds = intent.getIntExtra("Birds", -1)
            val city = intent.getIntExtra("city", -1)
            val quote = intent.getIntExtra("quote", -1)
            val astronaut = intent.getIntExtra("Astronaut", -1)
            val love = intent.getIntExtra("Love", -1)
            val flower = intent.getIntExtra("Flower", -1)
            val moon = intent.getIntExtra("Moon", -1)
            val travel = intent.getIntExtra("Travel", -1)
            val bw = intent.getIntExtra("Bw", -1)
            val sun = intent.getIntExtra("sun", -1)
            val anime = intent.getIntExtra("Anime", -1)
            val classic = intent.getIntExtra("Classic", -1)

            val allImage = intent.getIntExtra("all", 1)
            val favorite = intent.getIntExtra("favorite", -1)


            val image = if (name == "Nature") {
                nature
            } else if (name == "Artistic") {
                art
            } else if (name == "Food") {
                food
            } else if (name == "Sanatan Dharma") {
                god
            } else if (name == "Mountain") {
                mountain
            } else if (name == "Cute") {
                cute
            } else if (name == "Night") {
                night
            } else if (name == "Spring") {
                spring
            } else if (name == "Music") {
                music
            } else if (name == "Girly") {
                girly
            } else if (name == "Animal") {
                animal
            } else if (name == "Ocean") {
                ocean
            } else if (name == "Birds") {
                birds
            } else if (name == "City & Building") {
                city
            } else if (name == "Quotes") {
                quote
            } else if (name == "Astronaut") {
                astronaut
            } else if (name == "Love") {
                love
            } else if (name == "Flower") {
                flower
            } else if (name == "Moon") {
                moon
            } else if (name == "Travel") {
                travel
            } else if (name == "Black & White") {
                bw
            } else if (name == "Sun") {
                sun
            } else if (name == "Anime") {
                anime
            } else if (name == "Classic") {

                classic

            } else if (favname == "Your Favorite's") {

                favorite

            } else {
                allImage
            }


            Wallpaper_AppTheme {


                // todo(dialog)

                if (setWallpaper.value) {

                    Dialog(onDismissRequest = { setWallpaper.value = false }) {

                        Surface(
                            modifier = Modifier
                                .height(300.dp)
                                .width(270.dp),
                            color = Color.Black,
                            shape = RoundedCornerShape(10.dp)
                        ) {

                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Top,
                                modifier = Modifier.fillMaxSize()
                            ) {

                                Row(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .fillMaxWidth()
                                ) {

                                }

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(250.dp)
                                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                                        .clickable {

                                            setDrawableAsWallpaper(context = this@ShowPage, image)

                                        }
                                        .background(
                                            color = star.light_background
                                        )
                                ) {
                                    Text(
                                        text = "Set as Both",
                                        fontSize = 20.sp,
                                        color = star.textColor
                                    )
                                }

                                Row(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .fillMaxWidth()
                                ) {}

                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .clickable {



                                        }
                                        .height(60.dp)
                                        .width(250.dp)
                                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                                        .background(color = star.light_background)
                                ) {
                                    Text(
                                        text = "set as HomeScreen",
                                        fontSize = 20.sp,
                                        color = star.textColor
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .fillMaxWidth()
                                ) {

                                }


                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically,
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(250.dp)
                                        .clickable {

                                        }
                                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                                        .background(color = star.light_background)
                                ) {

                                    Text(
                                        text = "set as LockScreen",
                                        fontSize = 20.sp,
                                        color = star.textColor
                                    )

                                }

                                Row(
                                    modifier = Modifier
                                        .height(90.dp)
                                        .fillMaxWidth()
                                ) {
                                    Image(
                                        painter = painterResource(R.drawable.below),
                                        contentDescription = null,
                                    )

                                    Image(
                                        painter = painterResource(R.drawable.below),
                                        contentDescription = null,
                                    )

                                    Image(
                                        painter = painterResource(R.drawable.below),
                                        contentDescription = null,
                                    )
                                }


                            }

                        }


                    }

                }

                // todo( show page )

                Scaffold(topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = if (name == "Nature" || name == "Artistic" || name == "Food" || name == "Sanatan Dharma" || name == "Mountain" || name == "Cute" || name == "Night" || name == "Spring" || name == "Music" || name == "Girly" || name == "Animal" || name == "Ocean" || name == "Birds" || name == "City & Building" || name == "Quotes" || name == "Astronaut" || name == "Love" || name == "Flower" || name == "Moon" || name == "Travel" || name == "Black & White" || name == "Sun" || name == "Anime" || name == "Classic") {
                                    "  ${name} Wallpaper"

                                } else if (favname == "Your Favorite's") {

                                    "  Your Favorite's"

                                } else {
                                    "   All Wallpaper"
                                },
                                fontSize = 25.sp,
                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.moon))
                            )
                        },
                        actions = {
                            Image(
                                painter = painterResource(R.drawable.pflower),
                                contentDescription = null, modifier = Modifier.height(60.dp)
                            )
                        },
                    )
                }) { paddingValues ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {

                        Row(
                            modifier = Modifier
                                .height(10.dp)
                                .fillMaxWidth()
                        ) {

                        }

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .height(500.dp)
                                .fillMaxWidth()
                        ) {

                            Surface(
                                modifier = Modifier
                                    .height(500.dp)
                                    .width(300.dp), shape = RoundedCornerShape(10.dp)
                            ) {

                                Image(
                                    painter = painterResource(image),
                                    contentDescription = null,
                                    contentScale = ContentScale.FillBounds
                                )
                            }

                        }

                        Row(
                            modifier = Modifier
                                .height(190.dp)
                                .fillMaxWidth()
                        ) {

                            Row(
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .height(190.dp)
                                    .width(100.dp)
                            ) {

                                Icon(
                                    painter = painterResource(R.drawable.like),
                                    contentDescription = null,
                                    tint = star.red,
                                    modifier = Modifier
                                        .height(50.dp)
                                        .padding(15.dp)
                                        .clickable {


                                            val intent = Intent(this@ShowPage, Favorite::class.java)

                                            val myDatabase = Database(applicationContext)
                                            myDatabase.insertData(image = image)

                                            Log.d("===all===", "onCreate: ${allImage}")

                                            startActivity(intent)

                                        }
                                )

                            }

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .height(190.dp)
                                    .width(160.dp)
                            ) {

                                Button(
                                    onClick = {

                                        setWallpaper.value = true

                                    },
                                    modifier = Modifier
                                        .height(60.dp)
                                        .width(130.dp), shape = RoundedCornerShape(15.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = star.light_background),
                                    border = BorderStroke(3.dp, color = star.border)
                                ) {
                                    Text(
                                        text = "Set Wallpaper",
                                        fontSize = 17.sp,
                                        color = Color.White
                                    )
                                }

                            }

                            Row(
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .height(180.dp)
                                    .width(100.dp)
                            ) {

                                Icon(
                                    painter = painterResource(R.drawable.share1),
                                    contentDescription = null, modifier = Modifier
                                        .height(50.dp)
                                        .padding(15.dp)
                                        .clickable {

                                            shareToWhatsapp.shareImageToWhatsapp(
                                                context = this@ShowPage,
                                                image
                                            )

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

