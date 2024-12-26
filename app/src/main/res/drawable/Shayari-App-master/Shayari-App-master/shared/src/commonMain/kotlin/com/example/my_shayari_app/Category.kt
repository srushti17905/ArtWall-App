import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.my_shayari_app.ShayriPage
import com.example.my_shayari_app.star

var list = arrayOf(
    "Aankhein Shayari",
    "Love Shayari",
    "FriendShip Shayari",
    "Birthday Shayari",
    "Promise Shayari",
    "Krishna Shayari",
    "English Love Shayari",
    "Alone Shayari",
    "Barish Shayari",
    "Attitude Shayari",
    "Festival Shayari",
    "Success Shayari",
    "Motivational Shayari",
    "Proposeday Shayari",
    "Broken Heart Shayari",
    "Roseday Shayari",
    "Sorry Shayari",
    "Best Wishes Shayari",
    "Funny Shayari"
)

class Category : Screen {
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    override fun Content() {
        var navigator = LocalNavigator.current

        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize().weight(.1f).background(color = star.purple)
            ) {
                Text(
                    text = "All Shayari", fontSize = 30.sp, color = Color.White
                )
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize().weight(1f).background(color = star.purple)
            ) {
                items(list.size) { i ->
                    Surface(modifier = Modifier.fillMaxSize().padding(10.dp).height(70.dp),
                        shape = RoundedCornerShape(10.dp),
                        color = star.lightpurple,
                        onClick = {
                            navigator!!.push(ShayriPage(list[i]))

                        }) {

                            Box(
                                modifier = Modifier.fillMaxSize()
                                    .background(color = Color.Transparent),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(text = list[i], fontSize = 25.sp, color = Color.White)
                            }
                    }
                }
            }
        }
    }
}


