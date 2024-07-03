import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie.R
import com.example.movie.ui.theme.MovieTheme
import com.example.movie.ui.theme.color1
import com.example.movie.ui.theme.color2

class MainActivity<Bundle> : ComponentActivity() {
    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieTheme {
                Example()
            }
        }
    }
}
@Composable
fun TrendText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Trending Now",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = color1


            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "See All",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = color2



            )
            Spacer(modifier = modifier.width(25.dp))


        }
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Example() {
    Column(

    ) {
        Spacer(modifier =Modifier.height(10.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),

                    )
            },
            placeholder = {
                Text(
                    text = "Search movie or Tv series",
                    style = MaterialTheme.typography.bodySmall,

                    )
            },
            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.LightGray,
                disabledTextColor = Color.Black,
                cursorColor = Color.Black,
                disabledIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            textStyle = MaterialTheme.typography.bodySmall,

            )
    }

}
@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    MovieTheme {
        Example()
    }
}
@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TrendTextPreview() {
    Surface {
        TrendText()

    }
}
@Composable
fun Box(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(shape = RoundedCornerShape(corner = CornerSize(16.dp)))

        )


    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BoxPreview() {
    MovieTheme {
        Box(
            drawable = R.drawable.f1,
            modifier = Modifier.padding(8.dp)
        )
    }
}
@Composable
fun BoxRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyBoxRow) { item ->
                Box(drawable = item.drawable)
            }


        }
    }

}

private data class Image2(
    @DrawableRes val drawable: Int,
)

private val MyBoxRow = listOf(
    Image2(R.drawable.f1), // Correct Image object creation
    Image2(R.drawable.f2),
    Image2(R.drawable.f3),
    Image2(R.drawable.f4)
)





@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BoxRowPreview() {
    MovieTheme {
       BoxRow()
    }
}
@Composable
fun SpecialText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Special",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = color1


            )
            Spacer(modifier = modifier.weight(1f))



        }
    }

}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TopRatedTextPreview() {
    Surface {
       SpecialText()

    }
}
@Composable
fun Box2(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(360.dp)
                .height(210.dp)
                .clip(RoundedCornerShape(30.dp))
            ,
        )


    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun Box2Preview() {
    MovieTheme {
        Column {

            Box2(
                drawable = R.drawable.f6,

            )
        }

    }
}
@Composable
fun Box2Row(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(7.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyBox2Row) { item ->
                Box2(drawable = item.drawable)
            }


        }
    }

}

private data class Image(
    @DrawableRes val drawable: Int,
)

    private val MyBox2Row = listOf(
       Image2(R.drawable.f6),
Image2(R.drawable.f8),
Image2(R.drawable.f9),
Image2(R.drawable.f10)
)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun Box2RowPreview() {
    MovieTheme {
        Box2Row()
    }
}

@Composable
fun TvshowsText(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = modifier.width(25.dp))
            Text(
                text = "Tv Shows",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 16.sp,
                color = color1


            )
            Spacer(modifier = modifier.weight(1f))
            Text(
                text = "See All",
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 13.sp,
                color = color2



            )
            Spacer(modifier = modifier.width(25.dp))


        }
    }

}


@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
fun TvshowTextPreview() {
    Surface {
        TvshowsText()

    }
} @Composable
fun Image3(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int,

    ) {
    Image(
        painter = painterResource(drawable),
        contentDescription = "",
        modifier = modifier
            .width(140.dp)
            .height(260.dp)
            .clip(RoundedCornerShape(22.dp))
        ,
        contentScale = ContentScale.Crop
    )


}

@Preview(showBackground = true)
@Composable
fun Image3Preview() {
    MovieTheme {
        Column {

            Image3(
                drawable = R.drawable.a,
            )
        }

    }
}
@Composable
fun TvShowRowRow(modifier: Modifier = Modifier) {
    Column {
        Spacer(modifier = modifier.height(17.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier
        ) {
            items(MyTvShowRow) { item ->
                Image3(drawable = item.drawable)
            }

        }
    }

}








private data class MyImage3(
    @DrawableRes val drawable: Int,
)



private val MyTvShowRow = listOf(
    MyImage3(R.drawable.a ),
    MyImage3(R.drawable.b ),
    MyImage3(R.drawable.c ),
    MyImage3(R.drawable.d ),
    MyImage3(R.drawable.e ),


)

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun TvShowRowRowPreview() {
    MovieTheme {
        TvShowRowRow()
    }
}

@Composable
fun BottomNavigation(modifier: Modifier = Modifier) {





    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,

                    )
            },
            label = {
                Text(text = "Home")
            },

            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,

                    )
            },
            label = {
                Text(text = "Search")
            },

            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.popular), // Replace with your actual drawable
                    contentDescription = "Popular",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            },
            label = {
                Text(text = "Popular")
            },
            selected = false,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.serie), // Replace with your actual drawable
                    contentDescription = "Series",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            },
            label = {
                Text(text = "TV ")
            },
            selected = false,
            onClick = {}
        )
    }
}


@Composable
fun FullScreen(modifier: Modifier) {
    MovieTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation()
            },
            topBar = {

            }

        ) { innerPadding ->

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                contentPadding = PaddingValues(vertical = 4.dp),
                modifier = modifier.padding(innerPadding)
            ) {
                item {
                    Example()
                }
                item {
                    TrendText()
                }
                item {
                    BoxRow()
                }
                item {
                    TopRatedTextPreview()
                }
                item {
                    Box2Row()
                }
                item {
                    TvshowsText()
                }
                item {
                    TvShowRowRow()
                }

            }




        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun InstagramBottomNavigationPreview() {
    MovieTheme {
        BottomNavigation()
    }
}




@Preview(showBackground = true,)
@Composable
fun FullScreenPreview() {
    MovieTheme {
        FullScreen(modifier = Modifier)
    }
}