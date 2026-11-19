package com.example.rssaplication

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import com.example.rssaplication.ui.theme.RSSAplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        /*        val people = listOf(
                    Person("Griff", "Halloran", 25),
                    Person("Nik", "Skandaro", 29),
                    Person("Ary", "Quil", 28),
                    Person("Sen", "Fira", 30),
                    Person("Biddy", "Blas", 18),
                    Person("Lyren", "Shok", 17),
                    Person("Soren", "Zaks", 20)
                )*/

        //val peopleFiltered = people.filter { it.age < 21 }


        val rssItems = listOf(
            RSSItem(
                "Welcome to Lansing, Michigan",
                "Random text for testing in Lansing",
                RSSType.TEXT
            ),
            RSSItem(
                "Welcome to my Photo gallery",
                "Click here for gallery",
                RSSType.Image
            ),
            RSSItem(
                "Nvidia stops shipping US-approved AI chips to China",
                "Random text for testing",
                RSSType.VIDEO
            ),
            RSSItem(
                "GTA VI finally gets released after 10 years",
                "Commentfrom VideoGameDunkey",
                RSSType.TEXT
            ),
            RSSItem(
                "Microsoft Outlook down",
                "Microsoft 365 rolled back to 364",
                RSSType.TEXT
            ),
            RSSItem(
                "CHIMKIN!",
                "Random text for testing",
                RSSType.Image,
                R.drawable.image_of_chimkin
            ),
            RSSItem(
                "New gameplay footage for Sentinal",
                "Random text for testing",
                RSSType.VIDEO
            ),
            RSSItem(
                "FAA Grounds all flights",
                "Random text for testing",
                RSSType.TEXT
            ),
        )

        setContent {
            RSSAplicationTheme {
                LazyColumn {
                    items(rssItems) {
                        when (it.type) {
                            RSSType.TEXT -> {
                                RSSItemText(it)
                            }

                            RSSType.VIDEO -> {
                                RSSItemVideo(it)
                            }

                            RSSType.Image -> {
                                RSSItemImage(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = " $name",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RSSAplicationTheme {
        Greeting("Android")
    }
}

@Composable
fun RSSItemText(rssItem: RSSItem) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column() {
            Text(
                text = rssItem.title,
                fontSize = 32.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(12.dp)
            )
            Text(
                text = rssItem.text,
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@Composable
fun RSSItemVideo(rssItem: RSSItem) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Column {
            Text(
                text = rssItem.title,
                fontSize = 32.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Black,
                modifier = Modifier
                    .padding(12.dp)
                    .clickable {
                        Log.d("User", "Photo Tapped!")
                    }
            )
            Image(
                painter = painterResource(R.drawable.baseline_ondemand_video_24),
                contentDescription = "Video Player Icon",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Text(
                text = "Click icon to play video",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                fontSize = 10.sp
            )
        }
    }
}

@Composable
fun RSSItemImage(rssItem: RSSItem) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = rssItem.title,
            fontSize = 32.sp,
            lineHeight = 32.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(12.dp)
        )
        rssItem.media?.let { photo ->
            Image(
                painter = painterResource(id = photo),
                contentDescription = "Image icon",
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
