package com.firstcomposeapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.firstcomposeapp.MainActivity.Companion.TAG
import com.firstcomposeapp.ui.theme.FirstComposeAppTheme
import androidx.compose.ui.text.googlefonts.Font

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.Gray)
                        .alpha(0.5f)
                        .padding(12.dp)
            ) {
                Row(
                        modifier = Modifier
                            .background(color = Color.Green)
                            //We can give fixed width and height, we also have requiredWidth, requiredHeight
                            //as well, the diff. b/w width and requiredWidth is, say device actual width
                            //is 400, if we gave width(500), content after 400 is cut, it will not strech
                            //it beyond max device width, but with requiredWidth, the content will be
                            //600 dp , no matter how it looks on screen.
                            .width(240.dp)
                            .height(120.dp)
                        /*.requiredWidth(600.dp)*/,
                        //arrangement always talks abput main axis, so for row main axis is horizontal,
                        //while cross-axis is vertical, similarly for column main-axis is vertical and
                        //cross-axis is horizontal. alignment talks about cross-axis.
                        //For below example, SpaceEvenly --> the space between elements and space from
                        //left to first element and space from right to last element, all are same.
                        // SpaceBetween --> equal space between element, but no space from left or right,
                        //fully stretched.
                        //SpaceAround --> space between element equal, but from leftmost and rightmost edge
                        //it is half of the between space of elements.
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Hello", color = Color.Red)
                    Text(text = "World")
                    //we can this below way as well to fetch string from string resources.
                    Text(stringResource(R.string.app_name))
                    //old way to get string from resource.
                    //Text(resources.getString(R.string.app_name))

                }

                Spacer(modifier = Modifier.height(12.dp))

                //Here if we want to given fractional height and width, we can do this using
                // fillMaxSize(your value), 0.5f means 50%, i.e. 50% width of total width and 50%
                //height of total height. range is b/w 0 to 1.
                Column(
                        modifier = Modifier
                                .fillMaxSize(0.3f)
                                .background(Color.DarkGray)
                                .border(4.dp, Color.Magenta)
                                .padding(horizontal = 5.dp, vertical = 8.dp)
                                .border(5.dp, Color.Cyan)
                                .padding(5.dp)
                                .border(5.dp, Color.Yellow)
                ) {
                    //offset are similar to margins but not exactly, margins if applied to element can push
                    //the other element if it is overlapping, but offset won't push other elements.
                    //for below example, our text is pushed 20dp from left and 10dp from top.
                    Text(
                            text = "Hello",
                            color = Color.White,
                            modifier = Modifier.offset(x = 20.dp, y = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "World", color = Color.White)
                }


                textStyling()

            }


        }
    }

    companion object {
        const val TAG = "MainActivity"
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun textStyling() {
    val offset = Offset(5f, 10f)

    Text(
            text = "Hello world",
            color = Color.Magenta,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            letterSpacing = 4.sp,
            style = TextStyle(
                    //the text will only scale on horizontal axis
                    //skew value will tilt the text in left direction, while negative value will tilt it
                    //right direction.
                    textGeometricTransform = TextGeometricTransform(scaleX = 2f, skewX = 0.4f)
            ),
    )

    //using style property in text and using its attributes.
    Text(
            text = "Hello World",
            style = TextStyle(
                    fontSize = 24.sp,
                    shadow = Shadow(color = Color.Blue, offset = offset, blurRadius = 3f),
            )
    )

    //using annotatedString, we can different styling to different text or characters.
    //for below we are using buildAnnotatedString which is a builder, just like we have StringBuilder
    //for string.
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 24.sp)) {
            append('H')
        }
        append("ello")

        withStyle(style = SpanStyle(color = Color.Red, fontSize = 24.sp)) {
            append('W')
        }
        append("orld")
    })

    //or we can use Annotated String directly also, alternative to above
    /*Text(
        text = AnnotatedString(
            "H",
            spanStyle = SpanStyle(color = Color.Blue, fontSize = 24.sp)
        ).plus(
            AnnotatedString("ello").plus(
                AnnotatedString(
                    "W",
                    spanStyle = SpanStyle(color = Color.Red, fontSize = 24.sp)
                ).plus(AnnotatedString("orld",))
            )
        )
    )*/

    //Using decorators, overflow in text
    Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida massa laoreet ultrices porttitor.",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textDecoration = TextDecoration.LineThrough
    )

    //Using combine or plus functions, we can use multiple decorators at same time
    //using combine
    Text(
            text = "Hello world",
            textDecoration = TextDecoration.combine(
                    listOf(
                            TextDecoration.LineThrough,
                            TextDecoration.Underline
                    )
            )
    )

    //using plus
    Text(
            text = "Hello world",
            textDecoration = TextDecoration.Underline.plus(TextDecoration.LineThrough)
    )


    //using brush
    Text(
            text = "Hello world",
            fontWeight = FontWeight.ExtraBold,
            style = TextStyle(
                    brush = Brush.linearGradient(
                            colors = listOf(
                                    Color.Cyan,
                                    Color.Green,
                                    Color.Yellow
                            ),
                            start = Offset(0f, Float.POSITIVE_INFINITY),
                            end = Offset(0f, 0f)
                    ), fontSize = 30.sp
            )
    )

    Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus gravida massa laoreet ultrices porttitor.",
            maxLines = 1,
            fontFamily = FontFamily.Cursive,
            modifier = Modifier.basicMarquee()
    )

    //SelectableText()

    //This text is clickable
    Text(text = "this text is clickable!!", modifier = Modifier.clickable {
        Log.d(TAG, "textStyling: clicked!!")
    })

    Spacer(modifier = Modifier.height(12.dp))

    //use this if we want position of char clicked in text
    ClickableText(text = AnnotatedString("Click me"), onClick = {
        Log.d(TAG, "$it -th character is clicked ")
    })

    //AnnotatedClickableText()

    //Defining fontfamily with our downloaded fonts
    val myFontFamily = FontFamily(Font(R.font.dancing_script_regular, FontWeight.Normal), Font(R.font.dancing_script_bold, FontWeight.Bold))

    Text(text = "Bold", fontFamily =myFontFamily, fontWeight = FontWeight.Bold )
    Text(text = "Normal", fontFamily =myFontFamily, fontWeight = FontWeight.Normal )

    //Using downloaded font programmatical.

    val provider = GoogleFont.Provider(
        providerAuthority = "com.google.android.gms.fonts",
        providerPackage = "com.google.android.gms",
        certificates = R.array.com_google_android_gms_fonts_certs
    )


    val fontName = GoogleFont("Lobster Two")
    val googleFontFamily = FontFamily(
        Font(googleFont = fontName, fontProvider = provider, weight = FontWeight.Bold, style = FontStyle.Italic)
    )

    Text(
        fontFamily = googleFontFamily, text = "Hello World!"
    )
}


@Composable
fun SelectableText() {
    //To make text selectable, wrap it with SelectionContainer.
    SelectionContainer {
        Text(text = "Lorem ipsum dolor sit amet.")
    }

    SelectionContainer {
        Column {
            Text(text = "This text is selectable")
            Text(text = "This one too")
            //if we don't some text to be selectable, wrap it with DisableSelection
            DisableSelection {
                Text(text = "But not this one")
                Text(text = "Neither this one")
            }
            Text(text = "you select this one too")
        }
    }

}

@Composable
fun AnnotatedClickableText() {
    val annotatedText = buildAnnotatedString {
        append("Click ")

        // We attach this *URL* annotation to the following content
        // until `pop()` is called
        pushStringAnnotation(
                tag = "URL", annotation = "https://developer.android.com"
        )
        withStyle(
                style = SpanStyle(
                        color = Color.Blue, fontWeight = FontWeight.Bold
                )
        ) {
            append("here")
        }

        pop()
    }

    ClickableText(text = annotatedText, onClick = { offset ->
        // We check if there is an *URL* annotation attached to the text
        // at the clicked position
        annotatedText.getStringAnnotations(
                tag = "URL", start = offset, end = offset
        ).firstOrNull()?.let { annotation ->
            // If yes, we log its value
            Log.d("Clicked URL", annotation.item)
        }
    })
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
}