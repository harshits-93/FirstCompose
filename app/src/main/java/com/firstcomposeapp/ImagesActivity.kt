package com.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme

class ImagesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


                    //to have a gradient border on the images
                    val rainbowColorsBrush = Brush.sweepGradient(
                        listOf(
                            Color(0xFF9575CD),
                            Color(0xFFBA68C8),
                            Color(0xFFE57373),
                            Color(0xFFFFB74D),
                            Color(0xFFFFF176),
                            Color(0xFFAED581),
                            Color(0xFF4DD0E1),
                            Color(0xFF9575CD)
                        )
                    )
                    ImagesDemo(rainbowColorsBrush) 
                }
            }
        }
    }

}

@Composable
private fun ImagesDemo(rainbowColorsBrush: Brush) {
    Column {
        //to show png,jp,webp and vector images we use painterResource
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "hdjsahdajk",
            modifier = Modifier.padding(10.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.baseline_access_alarm_24),
            contentDescription = "fhdjh"
        )

        //but if want bitmap instance we wantt for further usage, use below code
        val bitmap = ImageBitmap.imageResource(id = R.drawable.profile_picture)

        //If we want customize the imagevector we can get its reference like this.
        val vectorResource: ImageVector =
            ImageVector.vectorResource(id = R.drawable.baseline_access_alarm_24)


        //Using vector icons directly without manually adding it
        Icon(Icons.Rounded.Phone, contentDescription = null)
        //Manually added vector icon can be used like this
        Icon(
            painter = painterResource(id = R.drawable.baseline_access_alarm_24),
            contentDescription = "dfsfds"
        )


        val modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
            .background(Color.Cyan)
            .padding(4.dp)


        Row {

        }
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .border(BorderStroke(2.dp, Color.Magenta), CircleShape)
                .padding(2.dp)
                .clip(
                    CircleShape
                )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .border(BorderStroke(4.dp, rainbowColorsBrush), CircleShape)
                .padding(4.dp)
                .clip(
                    CircleShape
                )
        )


    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FirstComposeAppTheme {
    }
}